package project.interceptor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import project.controler.PublicController;
import project.dto.CategoryDTO;
import project.service.CategoryService;
import project.service.CategoryServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class PrepareDataInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(PrepareDataInterceptor.class);

    private PublicController publicController;

    private CategoryService categoryService = new CategoryServiceImpl();
    //before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        System.out.println("preHandle: " + request.getRequestURI());
        String[] parts = request.getRequestURI().split("/");
        String path = request.getRequestURI();
        boolean pathChanged = false;
        while (path.endsWith("//")) {
            path = path.substring(0, path.length() - 1);
            pathChanged = true;
        }

        System.out.println(request.getAttribute("javax.servlet.error.status_code"));

        if (handler instanceof HandlerMethod && ((HandlerMethod) handler).getBean() instanceof PublicController && !path.endsWith("/")) {
            path += "/";
            pathChanged = true;
        }

        if (pathChanged) {
            response.sendRedirect(path);
            return false;
        }
//        System.out.println(handler.toString());
//        if(path.startsWith("/css") || path.startsWith("/css") || path.startsWith("/images")) {
////            request.getRequestDispatcher(path).forward(request, response);
//            return true;
//        } else {
//            return true;
//        }

        if (handler instanceof HandlerMethod && ((HandlerMethod) handler).getBean() instanceof PublicController) {
            publicController = (PublicController) ((HandlerMethod) handler).getBean();
            List<CategoryDTO> allMenuList = publicController.getAllCategories();
            request.setAttribute(PublicController.ALL_MENU, allMenuList);
        }

        return true;
    }

    //after the handler is executed
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView)
            throws Exception {

        long startTime = (Long) request.getAttribute("startTime");

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


        for (int i = 1; i < fragments.length; i++) {
            if (fragments[i].equals("") || fragments[i].substring(0, 1).equals(".")) {
                modelAndView.addObject("exception", "404");
                modelAndView.addObject("url", request.getRequestURL());
                modelAndView.setViewName("/error");
                break;
            }
        }

        if (fragments.length > 2) {
            Map<String, String> breadcrumbsPath = new LinkedHashMap<>();
            String path = "/";
            breadcrumbsPath.put(path, "Главная");

            if (fragments[1].equals(PublicController.VIDEOS)) {
                path += PublicController.VIDEOS + "/";
                breadcrumbsPath.put(path, "Видео");
            }

//            for (int i = 2; i < fragments.length; i++) {
//                String pageName = fragments[i];
//                path += pageName + "/";
//                CategoryDTO category = publicController.getByPageName(pageName);
//
//            }
//            String currentPageName = fragments[fragments.length - 1];
//            path += currentPageName + "/";
//            breadcrumbsPath.p

            List<CategoryDTO> pageNameList = publicController.getListByPageNameList(Arrays.asList(fragments));
            for(CategoryDTO category :pageNameList) {
                path += category.getPageName() + "/";
                breadcrumbsPath.put(path, category.getName());
            }
            modelAndView.addObject("breadcrumbsPath", breadcrumbsPath);
        }
    }
}