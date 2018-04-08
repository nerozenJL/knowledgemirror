package gof.knowledgemirror.filter;

import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*@WebFilter(urlPatterns={"/html/*","/index.jsp"}, filterName = "myfilter")*/
@WebFilter(urlPatterns="/html/test/*", filterName = "myfilter")
public class LoginFilter implements Filter{



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {



    }

    @Override
    public void doFilter(
            ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

       /* HttpSession session = ((HttpServletRequest)servletRequest).getSession();

        if(session.getAttribute("username")!=null){//已登录  放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else{//未登录 跳转登录界面
            //((HttpServletResponse)servletResponse).sendRedirect("/html/user/login.html");

            ((HttpServletResponse)servletResponse).sendRedirect("http://localhost:8080/showLogin");
            servletRequest.setAttribute("msg", "请先登录！");
        }*/

        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {

    }
}