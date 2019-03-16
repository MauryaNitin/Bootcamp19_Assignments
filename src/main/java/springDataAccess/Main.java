package springDataAccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDAO userDAO = context.getBean(UserDAO.class);
        SignupService signupService = context.getBean(SignupService.class);

//        System.out.println("All Users: ");
//        userDAO.displayAllUsers();
//
//
//        System.out.println("\nNo of Users: " + userDAO.getUserCount());
//
//        System.out.println("\nUsername: jon86 Name: " + userDAO.getName("jon86"));
//
//        User user = new User();
//        user.setName("heisenberg");
//        user.setUsername("BreakingBad2018");
//        user.setPassword("bb18");
//        user.setAge(35);
//        user.setDob("null");
//
////        System.out.println("\nAdding User: " + ((userDAO.addUser(user) == 1) ? "User Added Successfully!" : "Error Occurred!"));
//
//        System.out.println("\nUser details: " + userDAO.getUserDetails("nitin"));
//
//        System.out.println("\nList of Users: " + userDAO.getAllUsers());
//
//        System.out.println("\nUser details using RowMapper: " + userDAO.getUser("jon"));

        System.out.println("\nTotal Records: ");
        userDAO.getTotalRecords();

        User user1 = new User();
        user1.setName("Arya");
        user1.setUsername("arya123");
        user1.setPassword("got19");
        user1.setAge(21);
        user1.setDob("01/01/1999");

        signupService.signUp(user1);

        System.out.println("\nTotal Records: ");
        userDAO.getTotalRecords();
    }
}
