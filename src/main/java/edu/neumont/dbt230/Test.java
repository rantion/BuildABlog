package edu.neumont.dbt230;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Created by jjensen on 7/29/14.
 */
public class Test {
    public static void main(String[] args) {
//        String serverHost = "137.135.57.176";
//        String keyspace = "dev";
//
//        Cluster cluster = Cluster.builder().addContactPoints(serverHost).build();
//
//        Session session = cluster.connect(keyspace);
//        String cqlStatement = "insert into emp (empid, emp_first, emp_last, emp_dept) values (2, 'willma', 'smith', 'eng')";
//        session.execute(cqlStatement);
//
//        cqlStatement= "SELECT * FROM emp";
//        ResultSet rs = session.execute(cqlStatement);
//        for(Row row : rs) {
//            System.out.println(row.toString());
//        }

        CassandraInteraction cassandra = new CassandraInteraction();
        cassandra.printColumns();
    }
}
