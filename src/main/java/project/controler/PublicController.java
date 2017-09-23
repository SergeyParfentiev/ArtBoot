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

    private static String ALL_MENU = "allMenu";
    private static String CURRENT_MENU = "currentMenu";
    private static String SOURCE = "source";
    private static String VIDEOS = "videos";
    private static String AUTHORS = "authors";

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
    public ModelAndView index(ModelAndView model) throws ClassNotFoundException {
        String parameter = "LoL";
        model.addObject("parameter", parameter);
        System.out.println("index");
        List<CategoryDTO> allMenu = getAllCategories();
        model.addObject(ALL_MENU, allMenu);
        model.addObject(CURRENT_MENU, allMenu);
        model.addObject(SOURCE, VIDEOS);
        model.setViewName("/public/index");
        return model;
    }

    @RequestMapping(value = "/videos/**", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView home2(HttpServletRequest request, ModelAndView model) throws ClassNotFoundException {
        String categoriesURI = request.getRequestURI().replace("/videos", "");
        if(categoriesURI.startsWith("/")) {
            categoriesURI = categoriesURI.substring(1);
        }
        String[] pageNameArray = categoriesURI.split("/");
        if(pageNameArray.length != 0 && !pageNameArray[0].equals("")) {
            System.out.println(pageNameArray[0]);
            int level = 0;
            int sourceIndex = 0;
            CategoryDTO category = null;
            for (String pageName : pageNameArray) {
                category = categoryService.getCategoryByPageNameLevelSourceIndex(pageName, level, sourceIndex);
                if (category != null) {
                    System.out.println("name: " + category.getName() + " level: " + level + " sourceIndex: " + category.getSourceIndex());
                    level++;
                    sourceIndex = category.getIndex();
                } else {
                    model.setViewName("/error");
                    return model;
                }
            }

            String parameter = pageNameArray[pageNameArray.length - 1];
            model.addObject("parameter", parameter);
            model.addObject("param", category.getPageName());
            System.out.println();
            System.out.println("home2");

            model.addObject(ALL_MENU, getAllCategories());
            model.addObject(SOURCE, VIDEOS);
            model.setViewName("/public/index");

        } else {
            model.setViewName("/error");
        }
        return model;
    }

    private List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> allMenu = categoryService.getCategoryListByLevel(0);
        getSubCategories(allMenu);
        return allMenu;
    }

    private List<CategoryDTO> getCurrentMenu() {
        return null;
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
