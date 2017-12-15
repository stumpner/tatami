package it.balyfix;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;

import it.balyfix.domain.User;

public class App {
	public static void main(String[] args) {

		Cluster cluster = null;
		Session session = null;

		try {
			cluster = Cluster.builder().withProtocolVersion(ProtocolVersion.V3).addContactPoint("localhost").build();
			session = cluster.connect("tatami");

			MappingManager manager = new MappingManager(session);
			Mapper<User> mapper = manager.mapper(User.class);
			ResultSet result = session.execute("select * from user");
			Result<User> users = mapper.map(result);
			for(User user : users)
			{
				System.out.println("value user " + user.getLogin());
			}
			

		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			cluster.close();
		}
	}
}
