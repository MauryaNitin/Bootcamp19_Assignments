package com.ttn.springMvc.AnnotationsBased;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class EmployeeController {

    @RequestMapping("/employee")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping("/forms")
    public String forms(){
        return "forms";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping("/hello/model")
    public ModelAndView helloModel(){
        ModelAndView modelAndView = new ModelAndView("homepage");
        modelAndView.addObject("message", "helloWorld");
        return modelAndView;
    }

    @RequestMapping(value = "/firstname/{firstname}/lastname/{lastname}")
    @ResponseBody
    public String pathVariableDemo(@PathVariable String firstname, @PathVariable String lastname){
        return  "Welcome - " + firstname + lastname;
    }

    @RequestMapping("/employee/{firstname}/{lastname}")
    @ResponseBody
    String mapDemo(@PathVariable Map<String, String> requestMap) {
        return requestMap.toString();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    String requestParamDemo(@RequestParam String firstname, @RequestParam String lastname){
        return firstname + " " + lastname + " registered Successfully!";
    }

    @RequestMapping(value = "/employee/register", method = RequestMethod.POST)
    void setEmployeeCO(@RequestParam String firstname, @RequestParam String lastname, EmployeeCO employeeCO){
        employeeCO.setFirstname(firstname);
        employeeCO.setLastname(lastname);
        System.out.println(employeeCO.toString());
    }


    @ModelAttribute
    public void modelAttributeDemo(Model model){
        model.addAttribute("heading", "Spring MVC Demo");
    }
}
