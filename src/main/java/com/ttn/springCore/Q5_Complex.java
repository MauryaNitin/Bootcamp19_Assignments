package com.ttn.springCore;

/*

Ques 5:
Create Class Complex as follows:
class complex {
        List list;
        Set set;
        Map map;
} Initialize all the instance variables of the complex class using Spring XML. Give bean name as complexBean.
Get the bean and display the properties.
  */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

class Complex{
    List<Integer> list;
    Set<Integer> set;
    Map<String, Integer> map;


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}

public class Q5_Complex {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Complex complex = (Complex) context.getBean("complexBean");
        System.out.println("List : " + complex.getList());
        System.out.println("Set : " + complex.getSet());
        System.out.println("Map : " + complex.getMap());
    }
}
