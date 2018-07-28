package com.jnucst2015.dropshopping_digiwlet;

import com.jnucst2015.dropshopping.entity.Classification;
import com.jnucst2015.dropshopping.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("background")
public class MenuController {

    @Autowired
    private ClassificationService classificationService;

    @GetMapping("test")
    public String test(Model model) {
        model.addAttribute("classes", classificationService.getAllClassification());
        return "mng-classification";
    }

    @GetMapping("index")
    public String showBackgroundMenu(HttpSession session) {
        session.setAttribute("role", 2);
        session.setAttribute("classes", classificationService.getAllClassification());
        return "index_background";
    }

    @GetMapping("**")
    public String forceRoute(HttpSession session, HttpServletRequest request) {
        session.setAttribute("role", 2);
        session.setAttribute("classes", classificationService.getAllClassification());
        String url = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString().substring(11);
        return url;
    }

    @GetMapping("updateClass/{classid}")
    public String updateClass(@PathVariable("classid") Integer classid, Model model) {
        Classification temp = classificationService.getClassificationByID(classid);
        model.addAttribute("theclass", temp);
        return "mng-classification";
    }

    @GetMapping("deleteClass/{classid}")
    public String deleteClass(@PathVariable("classid") Integer classid) {
        classificationService.deleteByID(classid);
        return "redirect:/background/test";
    }

    @PostMapping("addClass")
    public String addClass(Classification newClass) {
        classificationService.addClassification(newClass);
        return "redirect:/background/test";
    }
}
