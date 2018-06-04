package pers.shayz.test;

import pers.shayz.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ZhouXiaoyu
 */
public class ConnectionFactoryTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory cf = ConnectionFactory.getInstance();

        Connection conn = cf.makeConnection();

        System.out.println(conn.getAutoCommit());
    }
}
