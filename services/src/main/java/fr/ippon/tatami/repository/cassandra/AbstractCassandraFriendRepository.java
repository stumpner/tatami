package fr.ippon.tatami.repository.cassandra;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Abstract class for managing friends : users or tags that a user follows.
 */
public abstract class AbstractCassandraFriendRepository {

   // private ColumnFamilyTemplate<String, String> friendsTemplate;

    //@Inject
    //private Keyspace keyspaceOperator;

    @PostConstruct
    public void init() {
//        friendsTemplate = new ThriftColumnFamilyTemplate<String, String>(keyspaceOperator,
//                getFriendsCF(),
//                StringSerializer.get(),
//                StringSerializer.get());
//
//        friendsTemplate.setCount(Constants.CASSANDRA_MAX_COLUMNS);
    }

    void addFriend(String key, String friendKey) {
//        Mutator<String> mutator = HFactory.createMutator(keyspaceOperator, StringSerializer.get());
//        mutator.insert(key, getFriendsCF(), HFactory.createColumn(friendKey,
//                Calendar.getInstance().getTimeInMillis(), StringSerializer.get(), LongSerializer.get()));
    }

    void removeFriend(String key, String friendKey) {
//        Mutator<String> mutator = HFactory.createMutator(keyspaceOperator, StringSerializer.get());
//        mutator.delete(key, getFriendsCF(), friendKey, StringSerializer.get());
    }

    List<String> findFriends(String key) {
//        ColumnFamilyResult<String, String> result = friendsTemplate.queryColumns(key);
//        List<String> friends = new ArrayList<String>();
//        for (String columnName : result.getColumnNames()) {
//            friends.add(columnName);
//        }
    //    return friends;
        return null;
    }

    protected abstract String getFriendsCF();
}
