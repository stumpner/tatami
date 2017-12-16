package fr.ippon.tatami.repository.cassandra;

import fr.ippon.tatami.repository.DiscussionRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Cassandra implementation of the StatusDetails repository.
 * <p/>
 * Structure :
 * - Key = originial status Id
 * - Name = time
 * - Value = reply status Id
 *
 * @author Julien Dubois
 */
@Repository
public class CassandraDiscussionRepository implements DiscussionRepository {

    @Inject
    //private Keyspace keyspaceOperator;

    @Override
    @CacheEvict(value = "status-cache", key = "#originalStatusId")
    public void addReplyToDiscussion(String originalStatusId, String replyStatusId) {
//        Mutator<String> mutator = HFactory.createMutator(keyspaceOperator, StringSerializer.get());
//        mutator.insert(originalStatusId, DISCUSSION_CF,
//                HFactory.createColumn(
//                        Calendar.getInstance().getTimeInMillis(),
//                        replyStatusId,
//                        LongSerializer.get(),
//                        StringSerializer.get()));
    }

    @Override
    public Collection<String> findStatusIdsInDiscussion(String originalStatusId) {
//        ColumnSlice<Long, String> result = createSliceQuery(keyspaceOperator,
//                StringSerializer.get(), LongSerializer.get(), StringSerializer.get())
//                .setColumnFamily(DISCUSSION_CF)
//                .setKey(originalStatusId)
//                .setRange(null, null, false, Integer.MAX_VALUE)
//                .execute()
//                .get();
//
//        Collection<String> statusIds = new LinkedHashSet<String>();
//        for (HColumn<Long, String> column : result.getColumns()) {
//            statusIds.add(column.getValue());
//        }
//        return statusIds;
        return null;
    }

    @Override
    public boolean hasReply(String statusId) {
//        int zeroOrOne = HFactory.createCountQuery(keyspaceOperator, StringSerializer.get(), LongSerializer.get())
//                .setColumnFamily(DISCUSSION_CF)
//                .setKey(statusId)
//                .setRange(null, null, 1)
//                .execute()
//                .get();

        //return zeroOrOne > 0;
        return true;
    }
}
