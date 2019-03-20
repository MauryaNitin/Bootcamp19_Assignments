package springDataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Inner Transactions

//    @Transactional(propagation = Propagation.REQUIRED)
//    public void sendMail(User user) {
//        userDAO.addUser(user);
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendMail(User user){
        userDAO.addUser(user);
        throw new RuntimeException("Email sent failed! - Server Down");
    }

//    @Transactional(propagation = Propagation.NESTED)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }

//    @Transactional(propagation = Propagation.MANDATORY)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }

//    @Transactional(propagation = Propagation.NEVER)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }

//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }

//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }
}
