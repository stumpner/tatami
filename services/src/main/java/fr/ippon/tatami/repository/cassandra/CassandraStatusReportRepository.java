package fr.ippon.tatami.repository.cassandra;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import fr.ippon.tatami.config.ColumnFamilyKeys;
import fr.ippon.tatami.repository.StatusReportRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;


/**
 * Cassandra implementation repository
 * Key: Domain
 * Name: reportedStatusId
 * value: reportingLogin
 */


@Repository
public class CassandraStatusReportRepository implements StatusReportRepository
{

    @Inject
    private Session session;

    @Override
    public void reportStatus(String domain, String reportedStatusId, String reportingLogin)
    {
        Insert statement = QueryBuilder.insertInto(ColumnFamilyKeys.STATUS_REPORT_CF).value("domain", domain)
            .value("reportedStatusId", reportedStatusId)
            .value("reportingLogin", reportingLogin);
        session.execute(statement);
    }

    @Override
    public void unreportStatus(String domain, String reportedStatusId)
    {
        Statement statement = QueryBuilder.delete().from(ColumnFamilyKeys.STATUS_REPORT_CF).where(eq("domain", domain)).and(eq("reportedStatusId", reportedStatusId));
        session.execute(statement);
    }

    @Override
    public List<String> findReportedStatuses(String domain)
    {
        Statement statement = QueryBuilder.select()
            .column("reportedStatusId")
            .from(ColumnFamilyKeys.STATUS_REPORT_CF)
            .where(eq("domain", domain));
        ResultSet results = session.execute(statement);
        return results
            .all()
            .stream()
            .map(e -> e.getString("reportedStatusId"))
            .collect(Collectors.toList());
    }

    public String findUserHavingReported(String domain, String statusId)
    {
        Statement statement = QueryBuilder.select().all()
            .from(ColumnFamilyKeys.STATUS_REPORT_CF)
            .where(eq("domain", domain));
        ResultSet results = session.execute(statement);

        return results
            .all()
            .stream().filter(item -> item.getString("reportedStatusId").equalsIgnoreCase(statusId))
            .map(row -> row.getString("reportingLogin"))
            .findFirst().orElse(StringUtils.EMPTY);
    }


    @Override
    public boolean hasBeenReportedByUser(String domain, String reportedStatusId, String login)
    {

        Statement statement = QueryBuilder.select().all()
            .from(ColumnFamilyKeys.STATUS_REPORT_CF)
            .where(eq("domain", domain));
        ResultSet results = session.execute(statement);

        List<Row> all = results.all();

        if (CollectionUtils.isNotEmpty(all))
        {
            return all.get(0).getString("reportingLogin").equalsIgnoreCase(login);
        }
        else
        {
            return false;
        }

    }

}
