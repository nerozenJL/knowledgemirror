package gof.knowledgemirror.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterCeptor implements HandlerInterceptor {

    //请求处理完毕之后
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
       // System.out.println("--afterCompletion--");

    }


    //controller之后
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        //System.out.println("--postHandle--");

    }

    //*Controller之前
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object arg2) throws Exception {

        HttpSession session = request.getSession();

        String name =
                (String) session.getAttribute("username");
        if (name != null) {//登陆过
            return true;//继续执行mvc后续流程

        } else {//未登陆过  或登录失效
            response.sendRedirect("showLogin");

            return false;//终止mvc后续流程
        }
    }
        //返回false表示将请求拦截了   后面过程也不执行了
}
