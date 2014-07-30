package edu.neumont.dbt230;

import com.datastax.driver.core.*;
import com.datastax.driver.core.policies.RetryPolicy;
import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import java.nio.ByteBuffer;
import java.util.*;

/**
 * Created by jjensen on 7/29/14.
 */
public class CassandraInteraction {

    private String serverHost;
    private String keyspace;
    private Cluster cluster;

    public CassandraInteraction() {
        serverHost = "137.135.57.176";
        keyspace = "blog";

    }

    private Session getSession() {
        cluster = Cluster.builder().addContactPoints(serverHost).build();

        return cluster.connect(keyspace);
    }

    /**
     * Returns a list off all the users from the cassandra
     * users table.
     * @return List
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = getSession();

        String cqlStatement = "select * from user";
        ResultSet rs = session.execute(cqlStatement);
        session.close();
        cluster.close();

        for(Row row : rs) {
            String username = row.getString("username");
            String password = row.getString("password");
            User user = new User(username, password);
            users.add(user);

        }

        return users;

    }

    public void printColumns() {
        Session session = getSession();
        String cqlStatement = "select * from user";
        ResultSet rs = session.execute(cqlStatement);
        Iterator iterator = rs.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }


        session.close();
        cluster.close();
    }

    /**
     * Adds user to the cassandra database table user
     * @param user
     */
    public void addUser(User user) {
        Session session = getSession();
        Insert insert = QueryBuilder.insertInto(session.getLoggedKeyspace(), "user")
                .value("username", user.getUserName())
                .value("password", user.getPassword());
        ResultSet resultSet = session.execute(insert);
        session.close();
        cluster.close();
    }

    public PriorityQueue<Post> getAllPosts() {
        PriorityQueue<Post> posts = new PriorityQueue<Post>();
        Session session = getSession();
        String cqlStatement = "select * from post";

        ResultSet rs = session.execute(cqlStatement);

        for(Row row : rs) {
            String title = row.getString("title");
            String content = row.getString("content");
            Date time = row.getDate("creation_time");
            String username = row.getString("username");

            User user = getUserByUsername(username);
            Post post = new Post(user, title, content, time);
            posts.add(post);
        }

        return posts;
    }

    public void addPost(Post post) {
        Session session = getSession();
        Insert insert = QueryBuilder.insertInto(session.getLoggedKeyspace(), "post")
                .value("title", post.getTitle())
                .value("content", post.getPostContent())
                .value("username", post.getPoster().getUserName())
                .value("creation_time", post.getTimeStamp());

        ResultSet resultSet = session.execute(insert);
        session.close();
        cluster.close();
    }

    /**
     * Returns a user pulled from cassandra
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {
        Session session = getSession();
        String cqlStatement = "select * from user where username = '" + username +"'";

        User user = new User("no user", "password");

        ResultSet rs = session.execute(cqlStatement);
        Row row;
        if( (row = rs.one()) != null) {
            user = new User(row.getString("username"), row.getString("password"));
        }

        return user;
    }



}
