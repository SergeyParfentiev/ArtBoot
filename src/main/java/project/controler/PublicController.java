package project.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class PublicController {

//    @Autowired
//    private ManagerService managerService;

    @RequestMapping("/")
    public String root() {
        return "/root";
    }

    @RequestMapping("/{language}/home")
    public String home(@PathVariable("language") String language) {
        return "/public/" + language + "/home";
    }
}
