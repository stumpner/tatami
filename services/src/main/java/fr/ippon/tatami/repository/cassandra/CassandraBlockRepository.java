package fr.ippon.tatami.repository.cassandra;

import fr.ippon.tatami.repository.BlockRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
/**
 * Created by matthieudelafourniere on 7/7/16.
 */

@Repository
public class CassandraBlockRepository implements BlockRepository {

//    private ColumnFamilyTemplate<String, String> blockedUsersTemplate;
//
//    @Inject
//    private Keyspace keyspaceOperator;

    @PostConstruct
    public void init() {
//        blockedUsersTemplate = new ThriftColumnFamilyTemplate<String, String>(keyspaceOperator,
//                BLOCK_USERS_CF,
//                StringSerializer.get(),
//                StringSerializer.get());
//
//        blockedUsersTemplate.setCount(Constants.CASSANDRA_MAX_COLUMNS);
    }

    @Override
    public void blockUser(String currentUserLogin, String blockedUserLogin) {
//        Mutator<String> mutator = HFactory.createMutator(keyspaceOperator, StringSerializer.get());
//        mutator.insert(currentUserLogin, BLOCK_USERS_CF, HFactory.createColumn(blockedUserLogin,
//                Calendar.getInstance().getTimeInMillis(), StringSerializer.get(), LongSerializer.get()));
    }

    @Override
    public void unblockUser(String currentUserLogin, String unblockedUserLogin) {
//        Mutator<String> mutator = HFactory.createMutator(keyspaceOperator, StringSerializer.get());
//        mutator.delete(currentUserLogin, BLOCK_USERS_CF, unblockedUserLogin, StringSerializer.get());

    }

    @Override
    public Collection<String> getUsersBlockedBy(String userLogin) {
//        ColumnFamilyResult<String, String> result = blockedUsersTemplate.queryColumns(userLogin);
//        Collection<String> blockedUsers = new ArrayList<String>();
//        for (String columnName : result.getColumnNames()) {
//            blockedUsers.add(columnName);
//        }
//        return blockedUsers;
        return null;
    }

    @Override
    public boolean isBlocked(String blockingLogin, String blockedLogin) {
        Collection<String> blockedEmails = getUsersBlockedBy(blockingLogin);
        return blockedEmails.contains(blockedLogin);
    }
}
