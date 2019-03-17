package springDataAccess;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    // Q10 - Use a rowMapper to get the User object when you query for a user

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setAge(rs.getInt("age"));
        user.setDob(rs.getString("dob"));
        return user;
    }
}
