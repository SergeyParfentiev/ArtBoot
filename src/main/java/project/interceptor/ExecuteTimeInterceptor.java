package project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import project.dto.CategoryDTO;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(ExecuteTimeInterceptor.class);

    //before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        System.out.println("preHandle: " + request.getRequestURI());
        String[] parts = request.getRequestURI().split("/");
        String path = request.getRequestURI();

        if(path.startsWith("/css") || path.startsWith("/css") || path.startsWith("/images")) {
//            request.getRequestDispatcher(path).forward(request, response);
            return true;
        } else {
            return true;
        }
//        return true;
    }
    //after the handler is executed
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView)
            throws Exception {

        long startTime = (Long)request.getAttribute("startTime");

        long endTime = System.currentTimeMillis();

        long executeTime = endTime - startTime;

        //modified the exisitng modelAndView
        modelAndView.addObject("executeTime", executeTime);

        //log it
//        if(logger.isDebugEnabled()){
//            logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
//        }

        System.out.println("postHandle\n");
        String uri = request.getRequestURI();
        String fragments[] = uri.split("/");
        for(int i = 1; i < fragments.length; i++) {
            if(fragments[i].equals("") || fragments[i].substring(0, 1).equals(".")) {
                modelAndView.addObject("exception", "404");
                modelAndView.addObject("url", request.getRequestURL());
                modelAndView.setViewName("/error");
                break;
            }
        }
    }
}