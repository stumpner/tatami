package fr.ippon.tatami.repository.cassandra;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import javax.inject.Inject;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;

/**
 * Abstract class for managing followers : users who follow another user or a tag.
 */
public abstract class AbstractCassandraFollowerRepository {

    @Inject
    private Session session;

    protected abstract String getFollowersCF();

    public void addFollower(String key, String login) {
        Statement statement = QueryBuilder.insertInto(getFollowersCF())
            .value("key", key)
            .value("login", login);
        session.execute(statement);

    }

    public void removeFollower(String key, String login) {
        Statement statement = QueryBuilder.delete()
            .from(getFollowersCF())
            .where(eq("key",key))
            .and(eq("login",login));
        session.execute(statement);
    }
}
