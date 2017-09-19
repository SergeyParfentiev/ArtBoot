package project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.dto.CategoryDTO;
import project.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class PublicController {

    @Autowired
    private CategoryService categoryService;

//    @RequestMapping("/")
//    public String root() {
//        return "/selectLanguage";
//    }

/*CategoryDTO category = new CategoryDTO();
        category.setName("Test");
        category.setPageName("test");
//        category.setChecky(9);
        categoryService.addCategory(category);*/

    @RequestMapping("/")
    public String home(Model model) throws ClassNotFoundException {
        String parameter = "LoL";
        model.addAttribute("parameter", parameter);
        System.out.println("home");
        List<CategoryDTO> list = categoryService.getCategoryListByLevel(0);
        getSubCategories(list);
//        for(CategoryDTO category : list) {
//            getSubCategories(category);
//        }
        model.addAttribute("list", list);
        return "/public/home";
    }

    @RequestMapping(value = "/videos/**", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView home2(HttpServletRequest request, ModelAndView model) throws ClassNotFoundException {
        String parameter = "LoL";
        model.addObject("parameter", parameter);
        String[] pageNameArray = request.getRequestURI().replace("/videos/", "").split("/");
        int level = 0;
        int sourceIndex = 0;
        for(String pageName : pageNameArray) {
            CategoryDTO category = categoryService.getCategoryByPageNameLevelSourceIndex(pageName, level, sourceIndex);
            if(category != null) {
                System.out.println("name: " + category.getName() + " level: " + level + " sourceIndex: " + category.getSourceIndex());
                level++;
                sourceIndex = category.getIndex();
            } else {
                System.out.println("pageName: " + pageName);
            }
        }
        System.out.println();
        System.out.println("home2");
        model.setViewName("/public/home");
        return model;
    }

    private void getSubCategories(CategoryDTO category) {
        if(category != null) {
            List<CategoryDTO> subCategories = categoryService.getSubCategories(category.getIndex());
//            System.out.print("categoryName: " + category.getName());
            if (subCategories != null && subCategories.size() != 0) {
                category.setSubCategoryList(subCategories);
//                System.out.println(" subCategories.size: " + subCategories.size());
                for (CategoryDTO subCategory : subCategories) {
                    getSubCategories(subCategory);
                }
            }
        }
    }

    private void getSubCategories(List<CategoryDTO> categories) {
        if(categories != null && categories.size() != 0) {
            for(CategoryDTO category : categories) {
//                System.out.print("categoryName: " + category.getName());
                List<CategoryDTO> subCategories = categoryService.getSubCategories(category.getIndex());
//                System.out.println(" subCategories.size: " + subCategories.size());
                category.setSubCategoryList(subCategories);
                getSubCategories(subCategories);
            }
        }
    }

    //        if(true) {
//            throw new ClassCastException();
//        }
//    @RequestMapping("/resources/**")
//    public String lol(HttpServletRequest req, Model model,@PathVariable Map<String, String> pathVariables) throws ClassNotFoundException {
//        String param = "LoL";
////        model.addAttribute("param", param);
//        System.out.println("lol");
//        for(String s : pathVariables.values()) {
//            System.out.println(s);
//        }
////        if(true) {
////            throw new ClassCastException();
////        }
//        String path = req.getRequestURI();
//        return path.substring(0, path.length() - 3);
//    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
//        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        StringWriter writer = new StringWriter();
        ex.printStackTrace(new PrintWriter(writer));
        System.out.println("handleError-> exception: " + writer);

//        Sender sender = new Sender("mywallofarts@gmail.com", "littlesky1");
//        sender.send("This is exception", writer.toString(), "mio-bio@bigmir.net");
//        sender.send("This is Subject", writer.toString(), "bouth@mail.ru");
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");

        return mav;
    }


}
