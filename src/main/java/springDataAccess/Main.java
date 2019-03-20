package springDataAccess;

/* Ques 1:  Create database springDemo with  user table with fields
                (a) username
                (b) password
                (c) name
                (d) age
                (e) dob
   Ques 2:  Insert few records inside user Tables
   Ques 3:  Use datasource with DriverManagerDataSource, dbcp2.BasicDataSource and
   Ques 4:  SingleConnectionDataSource to print the records of user tables
   Ques 5:  Use JdbcTemplate to get the count of users
   Ques 6:  Get name of the user by providing username to the parametrized query
   Ques 7:  Insert one record using JdbcTemplate
   Ques 8:  Use QueryForMap to fetch the user details of the  user
   Ques 9:  Use QueryForList to fetch records of all users
   Ques 10: Use a rowmapper to get the User object when you query for a user
   Ques 11: Integrate Hibernate with Spring and use hql query to count the number of records in user table.
   Ques 12: Use @Transactional to save to save 2 records using jdbc template with the following prapogation options
                REQUIRED
                REQUIRES_NEW
                NESTED
                MANDATORY
                NEVER
                NOT_SUPPORTED
                SUPPORTS
   Ques 13: Demonstrate the use of following options of @Transactional annotation
                read-only
                timeout
                rollback-for
                no-rollback-for
*/

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        UserDAO userDAO = context.getBean(UserDAO.class);
        SignupService signupService = context.getBean(SignupService.class);

        System.out.println("All Users: ");
        userDAO.displayAllUsers();


        System.out.println("\nNo of Users: " + userDAO.getUserCount());

        System.out.println("\nUsername: jon86 Name: " + userDAO.getName("jon86"));

        User user = new User();
        user.setName("heisenberg");
        user.setUsername("BreakingBad2018");
        user.setPassword("bb18");
        user.setAge(35);
        user.setDob("null");

//        System.out.println("\nAdding User: " + ((userDAO.addUser(user) == 1) ? "User Added Successfully!" : "Error Occurred!"));

        System.out.println("\nUser details: " + userDAO.getUserDetails("nitin"));

        System.out.println("\nList of Users: " + userDAO.getAllUsers());

        System.out.println("\nUser details using RowMapper: " + userDAO.getUser("jon"));

        System.out.println("\nTotal Records: ");
        userDAO.getTotalRecords();

        System.out.println("\nAll Users before signup: " + userDAO.getAllUsers().toString().replaceAll("},", "}\n"));

        signupService.signUp(user);

        System.out.println("\nAll Users from main: " + userDAO.getAllUsers().toString().replaceAll("},", "}\n"));
    }
}
