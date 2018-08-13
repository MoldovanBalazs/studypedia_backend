package ro.internteam.studypedia.resource;

import ro.internteam.studypedia.dao.DeadlineDao;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.Deadline;
import ro.internteam.studypedia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
public class DeadlineResource {

    @Autowired
    private DeadlineDao deadlineDao;

    @Autowired
    private UserDao userDao;

    @PostMapping("/insert")
    public Deadline insertDeadline(@RequestBody Deadline deadline) {
        deadline.setUser( userDao.findById(deadline.getUser().getId()).get());
        deadlineDao.save(deadline);
        deadline.setUser(null);
        return (deadline);
    }

    @DeleteMapping("/deadline")
    public String deleteDeadline(@RequestParam String deadlineId) {
        System.out.println(deadlineId);
        deadlineDao.delete(deadlineDao.findById(Integer.valueOf(deadlineId)).get());

        return deadlineId.toString();
    }

    @GetMapping(path = "/user/{userId}/deadlines")
    public @ResponseBody List<Deadline> getUserDeadlines(@PathVariable Integer userId) {
        //return userDao.findById(userId).get().getDeadlines();
        return deadlineDao.findAllByUserEqualsAndDateAfterOrderByDate(userDao.findById(userId).get(), LocalDateTime.now());
    }

    @GetMapping(path = "/deadline/{id}")
    public Deadline getDeadlineById(@PathVariable(name = "id") Integer id) {
        return deadlineDao.findById(id).get();
    }

    @PostMapping("/testInsertDeadline")
    public void insertUtility() {
        User user = userDao.findById(8).get();
        for(int i = 0; i <= 15; i ++) {
            Deadline deadline = new Deadline();
            deadline.setName("My new Deadline" + i);
            deadline.setUser(user);
            deadline.setDate(LocalDateTime.now());
            deadlineDao.save(deadline);
        }

        // return user.getUsername() + " successfully registered deadline with id: " + deadline.getId().toString() ;
    }
}
