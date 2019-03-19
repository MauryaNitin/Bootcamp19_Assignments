package com.ttn.springMvc.AnnotationsBased;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class EmployeeMultiActionController {
    @RequestMapping("/assignment")
    public ModelAndView assignment(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("assignment");
        return modelAndView;
    }

    @RequestMapping("/showHomepage")
    public ModelAndView showHomepage(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView modelAndView = new ModelAndView("homepage");
        return modelAndView;
    }

    @RequestMapping("/showResponse")
    public void showResponse(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html");
        response.getWriter().write("<h3> Http Response: </h2>");
        response.getWriter().write("<h3> Hello from Student Multi Action Controller</h2>");
    }
}
