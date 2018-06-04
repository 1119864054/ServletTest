package pers.shayz.dao.impl;

import pers.shayz.dao.UserDao;
import pers.shayz.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZhouXiaoyu
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void save(Connection conn, User user) throws SQLException {
        PreparedStatement ps = conn.prepareCall("INSERT  INTO user(name, password, email) VALUES (?,?,?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.executeUpdate();
    }

    @Override
    public void update(Connection conn, Long id, User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE user SET name = ?, password = ?, email = ? WHERE id = ?");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setLong(4, id);
        ps.executeUpdate();
    }

    @Override
    public void delete(Connection conn, User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM user WHERE id = ?");
        ps.setLong(1, user.getId());
        ps.executeUpdate();
    }

    @Override
    public ResultSet get(Connection conn, User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE name = ? AND password = ?");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        return ps.executeQuery();
    }
}
