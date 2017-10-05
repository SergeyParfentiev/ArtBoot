package project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.dto.CategoryDTO;
import project.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@Controller
@RequestMapping("/")
public class PublicController {

    public static String ALL_MENU = "all_menu";
    public static String CURRENT_MENU = "current_menu";
    public static String ALL_MENU_SOURCE = "all_menu_source";
    public static String CURRENT_MENU_SOURCE = "current_menu_source";
    public static String VIDEOS = "videos";
    public static String AUTHORS = "authors";

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
    public ModelAndView index(HttpServletRequest request, ModelAndView modelAndView) throws ClassNotFoundException {
        String parameter = "LoL";
        modelAndView.addObject("parameter", parameter);
        System.out.println("index");
//        List<CategoryDTO> allMenuList = (List<CategoryDTO>)request.getAttribute(ALL_MENU);
//        modelAndView.addObject(ALL_MENU, allMenuList);
        modelAndView.addObject(CURRENT_MENU, request.getAttribute(ALL_MENU));
        modelAndView.addObject(ALL_MENU_SOURCE, VIDEOS);
        modelAndView.addObject(CURRENT_MENU_SOURCE, VIDEOS);
        modelAndView.setViewName("/public/index");
        return modelAndView;
    }

    @RequestMapping(value = "/videos/**", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView home2(HttpServletRequest request, ModelAndView modelAndView,
                              @RequestParam(value = "ajax", required = false) boolean ajax) throws ClassNotFoundException {
        System.out.println(ajax);
        String categoriesURI = request.getRequestURI().replace("/videos", "");
        if (categoriesURI.startsWith("/")) {
            categoriesURI = categoriesURI.substring(1);
        }

        String[] pageNameArray = categoriesURI.split("/");
        List<CategoryDTO> categoriesToShow;
        StringBuilder categoriesPath = new StringBuilder(VIDEOS);
        if (!pageNameArray[0].equals("")) {
            System.out.println(pageNameArray[0]);
            int level = 0;
            int sourceIndex = 0;
            CategoryDTO category = null;
            for (String pageName : pageNameArray) {
                category = categoryService.getByPageNameAndLevelAndSourceIndex(pageName, level, sourceIndex);
                if (category != null) {
                    level++;
                    sourceIndex = category.getIndex();
                } else {
                    modelAndView.setViewName("/error");
                    return modelAndView;
                }
            }

            categoriesToShow = getSubOrSameLevelCategories(category, pageNameArray, categoriesPath);
        } else {
            categoriesToShow = (List<CategoryDTO>) request.getAttribute(ALL_MENU);
        }
        System.out.println("home2");
//        modelAndView.addObject(ALL_MENU, getAllCategories());
        modelAndView.addObject(CURRENT_MENU, categoriesToShow);
        modelAndView.addObject(ALL_MENU_SOURCE, VIDEOS);
        modelAndView.addObject(CURRENT_MENU_SOURCE, categoriesPath.toString());
        modelAndView.addObject("ajax", "lol");
        modelAndView.setViewName("/public/index");
        return modelAndView;
    }

    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> allMenu = categoryService.getListByLevel(0);
        getSubCategories(allMenu);
        return allMenu;
    }

    private List<CategoryDTO> getCurrentMenu() {
        return null;
    }

    //Если нету подкатегорий, тогда возвращаем надкатегории
    private List<CategoryDTO> getSubOrSameLevelCategories(CategoryDTO category, String[] pageNameArray, StringBuilder categoriesPath) {
        if (getSubCategories(category)) {
            for (String pageName : pageNameArray) {
                categoriesPath.append("/").append(pageName);
            }
            return category.getSubCategoryList();
        } else {
            for (int i = 0; i < pageNameArray.length - 1; i++) {
                categoriesPath.append("/").append(pageNameArray[i]);
            }
            return getSameLevelCategories(category);
        }
    }

    private boolean getSubCategories(CategoryDTO category) {
        boolean notEmpty = false;
        if (category != null) {
            List<CategoryDTO> subCategories = categoryService.getSubCategories(category.getIndex());
//            System.out.print("categoryName: " + category.getName());
            if (subCategories != null && subCategories.size() != 0) {
                notEmpty = true;
                category.setSubCategoryList(subCategories);
//                System.out.println(" subCategories.size: " + subCategories.size());
                for (CategoryDTO subCategory : subCategories) {
                    getSubCategories(subCategory);
                }
            }
        }
        return notEmpty;
    }

    private List<CategoryDTO> getPreCategories(CategoryDTO category) {
        return categoryService.getListPreCategoriesBySourceIndex(category.getSourceIndex());
    }

    private List<CategoryDTO> getSameLevelCategories(CategoryDTO category) {
        return categoryService.getListInSameLevel(category.getSourceIndex());
    }

    private void getSubCategories(List<CategoryDTO> categories) {
        if (categories != null && categories.size() != 0) {
            for (CategoryDTO category : categories) {
//                System.out.print("categoryName: " + category.getName());
                List<CategoryDTO> subCategories = categoryService.getSubCategories(category.getIndex());
//                System.out.println(" subCategories.size: " + subCategories.size());
                category.setSubCategoryList(subCategories);
                getSubCategories(subCategories);
            }
        }
    }

    public List<CategoryDTO> getListByPageNameList(List<String> pageNameList) {
        return categoryService.getListByPageNameList(pageNameList);
    }

    public CategoryDTO getByPageName(String pageName) {
        return categoryService.getByPageName(pageName);
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
