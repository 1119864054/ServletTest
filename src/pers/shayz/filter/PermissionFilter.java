package pers.shayz.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ZhouXiaoyu
 */
public class PermissionFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        String servletPath =request.getServletPath();

        HttpSession session = request.getSession();
        String flag = (String) session.getAttribute("flag");

        boolean isExisted=(servletPath != null) &&
                (servletPath.equals("login.jsp")||servletPath.equals("index.jsp")||servletPath.equals("/LoginServlet"));

        if(isExisted){
            chain.doFilter(req, resp);
        }else {
            if (flag!=null&&flag.equals("login_success")){
                chain.doFilter(req, resp);
            }else if(flag!=null&&flag.equals("login_error")){
                request.setAttribute("msg", "登陆失败，请重新登录!!!");
                request.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }else{
                request.setAttribute("msg", "您尚未登录！！！");
                request.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
