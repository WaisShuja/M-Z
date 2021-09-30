package mz.painting.com.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class RegisterInterceptor extends HandlerInterceptorAdapter {



        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

             String sessionId = null;

              if(null != request.getCookies()){
                  for (Cookie cookie: request.getCookies()){
                      if("JSESSIONID".equals(cookie.getName())){
                          sessionId = cookie.getValue();
                      }
                  }
              }
            System.out.println("Incoming request : sessionID " + sessionId + " for " + request.getRequestURI() +
                    " at " + new Date());
            return true;
        }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model){
        System.out.println("In postHandle");
    }
}