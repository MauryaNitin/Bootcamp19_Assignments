package springDataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignupService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private EmailService emailService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void signUp(User user){
        int res = userDAO.addUser(user);
        System.out.println("\nSignup: " + ((res == 1) ? "success": "failed"));
        System.out.println("\nAll Users: " + userDAO.getAllUsers().toString().replaceAll("},", "}\n"));
        try{
            emailService.sendMail(user);
        }catch (RuntimeException e){
            System.err.println("\n" + e.getMessage());
        }
        System.out.println("\nAll Users: " + userDAO.getAllUsers().toString().replaceAll("},", "}\n"));
    }

//    @Transactional(readOnly = true)
//    public void signUp(User user){
//        int res = userDAO.addUser(user);
//        System.out.println("\nSignup: " + ((res == 1) ? "success": "failed"));
//    }

//    @Transactional(timeout = 2)
//    public void signUp(User user){
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int res = userDAO.addUser(user);
//        System.out.println("\nSignup: " + ((res == 1) ? "success": "failed"));
//    }

//    @Transactional(rollbackFor = RuntimeException.class)
//    public void signUp(User user){
//        int res = userDAO.addUser(user);
//        System.out.println("\nSignup: " + ((res == 1) ? "success": "failed"));
//        throw new RuntimeException("Signup Failed!!");
//    }

//    @Transactional(noRollbackFor = UnsupportedOperationException.class)
//    public void signUp(User user){
//        int res = userDAO.addUser(user);
//        System.out.println("\nSignup: " + ((res == 1) ? "success": "failed"));
//        throw new UnsupportedOperationException("Signup Failed!!");
//    }


}
