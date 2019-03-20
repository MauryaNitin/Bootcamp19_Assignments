package springDataAccess;

/***
 * Ques 12: Use @Transactional to save to save 2 records using jdbc template with the following prapogation options
 *              REQUIRED
 *              REQUIRES_NEW
 *              NESTED
 *              MANDATORY
 *              NEVER
 *              NOT_SUPPORTED
 *              SUPPORTS
 *
 * Ques 13: Demonstrate the use of following options of @Transactional annotation
 *              read-only
 *              timeout
 *              rollback-for
 *              no-rollback-for
 */

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
    JdbcTemplate jdbcTemplate;

    @Autowired
    private EmailService emailService;

    // Outer Transaction
    @Transactional(propagation = Propagation.REQUIRED)
    public void signUp(User user) {
        userDAO.addUser(user);
        try {
            emailService.sendMail(user);
        } catch (RuntimeException e) {
            System.err.println("\n" + e.getMessage());
        }
    }

//    @Transactional(readOnly = true)
//    public void signUp(User user){
//        int res = userDAO.addUser(user);
//    }

//    @Transactional(timeout = 2)
//    public void signUp(User user){
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int res = userDAO.addUser(user);
//    }

//    @Transactional(rollbackFor = RuntimeException.class)
//    public void signUp(User user){
//        int res = userDAO.addUser(user);
//        throw new RuntimeException("Signup Failed!!");
//    }

//    @Transactional(noRollbackFor = UnsupportedOperationException.class)
//    public void signUp(User user){
//        int res = userDAO.addUser(user);
//        throw new UnsupportedOperationException("Signup Failed!!");
//    }

}
