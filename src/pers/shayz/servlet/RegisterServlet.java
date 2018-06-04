package pers.shayz.servlet;

import pers.shayz.dao.UserDao;
import pers.shayz.dao.impl.UserDaoImpl;
import pers.shayz.entity.User;
import pers.shayz.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @author ZhouXiaoyu
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;

        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            UserDao userDao = new UserDaoImpl();
            User user = new User();
            user.setName(request.getParameter("userName"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));

            userDao.save(conn, user);

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
