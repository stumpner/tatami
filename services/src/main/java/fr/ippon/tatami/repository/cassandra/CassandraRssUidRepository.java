package fr.ippon.tatami.repository.cassandra;

import fr.ippon.tatami.repository.RssUidRepository;
import org.springframework.stereotype.Repository;

/**
 * Cassandra implementation of the RssUid repository.
 * <p/>
 * Structure : - Key = "rss_uid" - Name = key - Value = login
 *
 * @author Pierre Rust
 */
@Repository
public class CassandraRssUidRepository implements RssUidRepository {

    private final static String ROW_KEY = "rss_uid";

    //@Inject
    //private Keyspace keyspaceOperator;

    @Override
    public String generateRssUid(String login) {
//        String key = RandomUtil.generateRegistrationKey();
//        HColumn<String, String> column = HFactory.createColumn(key,
//                login, StringSerializer.get(), StringSerializer.get());
//
//        Mutator<String> mutator = HFactory.createMutator(keyspaceOperator, StringSerializer.get());
//        mutator.insert(ROW_KEY, RSS_CF, column);
//        return key;
        return null;
    }

    @Override
    public String getLoginByRssUid(String rssUid) {
//        ColumnQuery<String, String, String> query = HFactory.createStringColumnQuery(keyspaceOperator);
//        HColumn<String, String> column =
//                query.setColumnFamily(RSS_CF)
//                        .setKey(ROW_KEY)
//                        .setName(rssUid)
//                        .execute()
//                        .get();
//
//        if (column != null) {
//            return column.getValue();
//        } else {
//            return null;
//        }
        return null;
    }

    @Override
    public void removeRssUid(String rssUid) {
//        Mutator<String> mutator = HFactory.createMutator(keyspaceOperator, StringSerializer.get());
//        mutator.delete(ROW_KEY, RSS_CF, rssUid, StringSerializer.get());
    }
}
