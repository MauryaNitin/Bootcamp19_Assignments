package com.ttn.springMvc.Q1_Q2;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentMultiActionController extends MultiActionController {
    public ModelAndView assignment(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("assignment");
        return modelAndView;
    }

    public ModelAndView showHomepage(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView modelAndView = new ModelAndView("homepage");
        return modelAndView;
    }

    public void showResponse(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html");
        response.getWriter().write("<h3> Http Response: </h2>");
        response.getWriter().write("<h3> Hello from Student Multi Action Controller</h2>");
    }
}