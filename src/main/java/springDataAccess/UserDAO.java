package springDataAccess;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.Map;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    DriverManagerDataSource dataSource;         // Q3

//    @Autowired
//    BasicDataSource dataSource;               // Q3

//    @Autowired
//    SingleConnectionDataSource dataSource;    // Q4

    @Autowired
    SessionFactory sessionFactoryBean;          // Q11

    @Autowired
    JdbcTemplate jdbcTemplate;                  // Q5


    // Q3 and Q4
    // printing the records of User table using different datasources
    void displayAllUsers() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Name: " + resultSet.getString("name") + "\t Username: " +
                    resultSet.getString("username") + "\t Age: " + resultSet.getString("age"));
        }
    }

    // Q5 - Get count of users using JdbcTemplate
    Integer getUserCount() {
        String sql = "SELECT COUNT(username) FROM User";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    // Q6 - Get name of the user by providing username to the parametrized query
    String getName(String username) {
        String sql = "SELECT name FROM User WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, String.class);

    }

    // Q7 - Inserting a User using JdbcTemplate
    int addUser(User user) {
        String sql = "Insert into User values (?,?,?,?,?)";
        return jdbcTemplate.update(sql, user.getName(), user.getUsername(), user.getPassword(), user.getAge(), user.getDob());
    }

    // Q8 - Fetching the details of the user using queryForMap
    Map getUserDetails(String name) {
        String sql = "SELECT * FROM User WHERE name = ?";
        return jdbcTemplate.queryForMap(sql, name);

    }

    // Q9 - Fetching the records of all the users using queryForList
    List getAllUsers() {
        String sql = "SELECT * FROM User";
        return jdbcTemplate.queryForList(sql);
    }

    // Q10 - Use a rowMapper to get the User object when you query for a user
    User getUser(String name) {
        String sql = "SELECT * FROM User WHERE name = ?";
        return (jdbcTemplate.queryForObject(sql, new Object[]{name}, new UserMapper()));
    }

    // Q11 - Integrate Hibernate with Spring and use hql query to count the number of records in user table.
    void getTotalRecords() {
        String sql = "select  count(*) from User";
        Query query = sessionFactoryBean.openSession().createQuery(sql);
        System.out.println(query.uniqueResult());
    }

}


