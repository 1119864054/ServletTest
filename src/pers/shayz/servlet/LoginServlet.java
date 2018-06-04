package pers.shayz.servlet;

import pers.shayz.entity.User;
import pers.shayz.service.CheckUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZhouXiaoyu
 */
public class LoginServlet extends HttpServlet {

    private CheckUserService checkUserService = new CheckUserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String passwd = request.getParameter("upwd");

        RequestDispatcher rd = null;

        if (uname == null || passwd == null) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        } else {
            User user = new User();
            user.setName(uname);
            user.setPassword(passwd);
            boolean bool = checkUserService.check(user);

            if (bool) {
                request.getSession().setAttribute("flag", "login_success");
                rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request, response);
            } else {
                request.getSession().setAttribute("flag", "login_error");
                request.setAttribute("msg", "用户名或密码输入错误，请重新输入！");
                rd = request.getRequestDispatcher("error.jsp");
                rd.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
