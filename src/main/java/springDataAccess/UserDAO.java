package springDataAccess;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.List;

@Transactional
public class UserDAO {

    @Autowired
    DriverManagerDataSource dataSource;

    @Autowired
    SessionFactory sessionFactoryBean;
//
//    @Autowired
//    SingleConnectionDataSource dataSource;

//    @Autowired
//    BasicDataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    void displayAllUsers() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Name: " + resultSet.getString("name") + "\t Username: " +
                    resultSet.getString("username") + "\t Age: " + resultSet.getString("age"));
        }
    }

    Integer getUserCount() {
        String sql = "SELECT COUNT(username) FROM User";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    String getName(String username) {
        String sql = "SELECT name FROM User WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, String.class);

    }


    int addUser(User user){
        String sql = "Insert into User values (?,?,?,?,?)";
        return jdbcTemplate.update(sql, user.getName(), user.getUsername(), user.getPassword(), user.getAge(), user.getDob());
    }

    Map getUserDetails(String name) {
        String sql = "SELECT * FROM User WHERE name = ?";
        return jdbcTemplate.queryForMap(sql, name);

    }

    List getAllUsers(){
        String sql = "SELECT * FROM User";
        return jdbcTemplate.queryForList(sql);
    }

    User getUser(String name){
        String sql =  "SELECT * FROM User WHERE name = ?";
        return (jdbcTemplate.queryForObject(sql, new Object[]{name}, new UserMapper()));
    }

    void getTotalRecords() {
        String sql = "select  count(*) from User";
        Query query = sessionFactoryBean.openSession().createQuery(sql);
        System.out.println(query.uniqueResult());
    }

}


