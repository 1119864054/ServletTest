package pers.shayz.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author ZhouXiaoyu
 */
public class ConnectionFactory {

    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;

    private static final ConnectionFactory factory = new ConnectionFactory();

    private Connection conn;

    static {
        Properties properties = new Properties();
        try {
            InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            properties.load(in);
        } catch (IOException e) {
            System.out.println("========配置文件读取错误=======");
        }

        driver = properties.getProperty("driver");
        dburl = properties.getProperty("dburl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    private ConnectionFactory(){

    }

    public static ConnectionFactory getInstance(){
        return factory;
    }

    public Connection makeConnection(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
