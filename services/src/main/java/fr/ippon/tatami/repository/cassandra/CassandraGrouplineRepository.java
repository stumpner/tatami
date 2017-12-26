package fr.ippon.tatami.repository.cassandra;

import com.datastax.driver.core.PreparedStatement;
import fr.ippon.tatami.config.ColumnFamilyKeys;
import fr.ippon.tatami.repository.GrouplineRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

import static fr.ippon.tatami.config.ColumnFamilyKeys.GROUPLINE_CF;

/**
 * Cassandra implementation of the Group line repository.
 * <p/>
 * Structure :
 * - Key = groupId
 * - Name = statusId
 * - Value = ""
 *
 * @author Julien Dubois
 */
@Repository
public class CassandraGrouplineRepository extends AbstractCassandraLineRepository implements GrouplineRepository
{

    private PreparedStatement findByLoginStmt;

    private PreparedStatement deleteByIdStmt;


    @PostConstruct
    public void init() {
        findByLoginStmt = session.prepare(
            "SELECT * " +
                "FROM " + GROUPLINE_CF+
                " WHERE key = :key");

        deleteByIdStmt = session.prepare("DELETE FROM " + GROUPLINE_CF +
            " WHERE key = :key " +
            "AND status = :statusId");

    }

    @Override
    public void addStatusToGroupline(String groupId, String statusId)
    {
        addStatus(groupId.toString(), ColumnFamilyKeys.GROUPLINE_CF, statusId);
    }

    @Override
    public void removeStatusesFromGroupline(String groupId, Collection<String> statusIdsToDelete) {
        removeStatuses(groupId, ColumnFamilyKeys.GROUPLINE_CF, statusIdsToDelete);
    }

    @Override
    public List<String> getGroupline(String groupId, int size, String start, String finish) {
        return getLineFromTable(ColumnFamilyKeys.GROUPLINE_CF, groupId, size, start, finish);
    }

    @Override
    public PreparedStatement getDeleteByIdStmt() {
        return deleteByIdStmt;
    }
}
