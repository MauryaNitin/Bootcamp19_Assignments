package springDataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {

    @Autowired
    UserDAO userDAO;

    // Inner Transaction
    @Transactional(propagation = Propagation.REQUIRED)
    public void sendMail(User user) {
        int res = userDAO.addUser(user);
        System.out.println("\nEmail Send: " + ((res == 1) ? "success" : "failed"));
        throw new RuntimeException("Email sent failed! - Server Down");
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        System.out.println("\nEmail Send: " + ((res == 1) ? "success": "failed"));
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }

//    @Transactional(propagation = Propagation.NESTED)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        System.out.println("\nEmail Send: " + ((res == 1) ? "success": "failed"));
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }

//    @Transactional(propagation = Propagation.MANDATORY)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        System.out.println("\nEmail Send: " + ((res == 1) ? "success": "failed"));
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }

//    @Transactional(propagation = Propagation.NEVER)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        System.out.println("\nEmail Send: " + ((res == 1) ? "success": "failed"));
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }

//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        System.out.println("\nEmail Send: " + ((res == 1) ? "success": "failed"));
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }


//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void sendMail(User user){
//        int res = userDAO.addUser(user);
//        System.out.println("\nEmail Send: " + ((res == 1) ? "success": "failed"));
//        throw new RuntimeException("Email sent failed! - Server Down");
//    }

}
