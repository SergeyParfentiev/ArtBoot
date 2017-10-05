package project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@Controller
public class CustomErrorController implements ErrorController {

    @Autowired
    ErrorAttributes errorAttributes;

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView error(HttpServletRequest httpRequest) {
        System.out.println("error");
        Integer httpErrorCode = getErrorCode(httpRequest);
        RequestAttributes requestAttributes = new ServletRequestAttributes(httpRequest);
        System.out.println(errorAttributes.getErrorAttributes(requestAttributes, true));
        ModelAndView errorPage = new ModelAndView("/errors/error");
        String errorMsg = httpErrorCode + ": Такие вот дела";
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    private Integer getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
    }
}