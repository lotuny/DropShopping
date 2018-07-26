package com.jnucst2015.dropshopping_digiwlet;

import com.jnucst2015.dropshopping.entity.Classification;
import com.jnucst2015.dropshopping.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("background")
public class MenuController {

    @Autowired
    private ClassificationService classificationService;

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

    @GetMapping("deleteClass/{classid}")
    public String deleteClass(@PathVariable("classid") Integer classid) {
        classificationService.deleteByID(classid);
        return "index_background";
    }

    @PostMapping("addClass")
    public String addClass(Classification newClass) {
        classificationService.addClassification(newClass);
        return "index_background";
    }
}
