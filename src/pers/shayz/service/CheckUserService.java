package pers.shayz.service;

import pers.shayz.dao.UserDao;
import pers.shayz.dao.impl.UserDaoImpl;
import pers.shayz.entity.User;
import pers.shayz.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author ZhouXiaoyu
 */
public class CheckUserService {

    private UserDao userDao = new UserDaoImpl();

    public boolean check(User user){
        Connection conn = null;

        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            ResultSet resultSet = userDao.get(conn, user);

            while (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                assert conn != null;
                Objects.requireNonNull(conn).close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
