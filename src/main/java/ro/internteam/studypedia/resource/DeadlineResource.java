package ro.internteam.studypedia.resource;

import ro.internteam.studypedia.dao.DeadlineDao;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.Deadline;
import ro.internteam.studypedia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Random;

@RestController
@CrossOrigin
public class DeadlineResource {

    @Autowired
    private DeadlineDao deadlineDao;

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/insertNewUser")
    public String insertNewUser() {
        User user = new User();
        user.setName("Ion");
        user.setUsername("Ion@Bo$$");
        userDao.save(user);

        return "user " + user.getName() + " with username " + user.getUsername() + " registered in the system";
    }

    @GetMapping(path = "/getUserDeadline")
    public String getUserDeadline() {

        User user = userDao.findById(1).get();
        return  userDao.findById(user.getId()).get().getDeadlines().toString();
    }

    public String insertNewDeadline(User user) {

        for(int i = 0; i < 5; i++) {
            Deadline deadline = new Deadline();
            deadline.setName("Article #" + new Random() + "from " + user.getName());
            deadline.setUser(user);
            deadline.setDate(LocalDate.now());

            deadlineDao.save(deadline);
        }

        return "Deadline registered successfully";
    }

    public String findUser() {
        return "Name " + userDao.findById(1).get().getName();
    }

    @GetMapping(path = "/testDeadlineInsert")
    public String testDeadlineInsert() {
        User user = userDao.findById(1).get();
        return insertNewDeadline(user);
    }


}
