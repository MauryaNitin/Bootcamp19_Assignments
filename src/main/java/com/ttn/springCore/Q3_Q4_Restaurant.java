package com.ttn.springCore;

/*
* Ques 3: Create a class Restaurant. Create an interface HotDrink with an abstract method prepareHotDrink. Create two classes
*   Tea and ExpressTea which implements HotDrink Class. Create an instance variable of type HotDrink in Restaurant class.
*   Configure Tea and ExpressTea classes beans in Spring XML. create a bean with the name teaRestaurant of type Restaurant
*   which inject Tea object as dependency using setter method.
*
* Ques 4: Get both the beans and invoke prepareHotDrink method via hotDrink instance variables. Try inner bean with expressTeaRestaurant.
*
* Ques 7: Set the scope of the teaRestaurant bean as prototype and check the scope type after accessing the bean.
*
* Ques 8: Use @Required annotation for hotDrink setter method in Restaurant class.
 */

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
interface HotDrink{
    void prepareHotDrink();
}

@Component
class Tea implements HotDrink{
    @Override
    public void prepareHotDrink() {
        System.out.println("Preparing Tea....");
    }

    @Override
    public String toString() {
        return "Tea";
    }

}

@Component
class ExpressTea implements HotDrink{
    @Override
    public void prepareHotDrink() {
        System.out.println("Preparing Express Tea... ");
    }


    @Override
    public String toString() {
        return "ExpressTea";
    }
}

@Controller
class Restaurant{
    private HotDrink drink;

    public HotDrink getDrink() {
        return drink;
    }

    @Required  /* Ques 8 */
    public void setDrink(HotDrink drink) {
        this.drink = drink;
    }
}


public class Q3_Q4_Restaurant {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println(context.getBean("teaRestaurant", Restaurant.class).getDrink());

        /*Ques 4*/
        HotDrink drink = context.getBean("tea", Tea.class);
        drink.prepareHotDrink();

        drink = context.getBean("expressTea", ExpressTea.class);
        drink.prepareHotDrink();

        Restaurant restaurant = context.getBean("expressTeaRestaurant", Restaurant.class);
        System.out.println(restaurant.getDrink());

        /* Ques 7 */
        System.out.println("\nPrototype: " + context.isPrototype("teaRestaurant"));


    }
}
