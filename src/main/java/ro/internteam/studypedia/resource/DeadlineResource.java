package ro.internteam.studypedia.resource;

import ro.internteam.studypedia.dao.DeadlineDao;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.Deadline;
import ro.internteam.studypedia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DeadlineResource {

    @Autowired
    private DeadlineDao deadlineDao;

    @Autowired
    private UserDao userDao;

    @PostMapping("/newdeadline")
    public void insertDeadline(@RequestBody Deadline deadline) {
        deadlineDao.save(deadline);
    }

    @GetMapping(path = "/user/{id}/deadlines")
    public List<Deadline> getUserDeadlines(@PathVariable(value = "id") Integer id) {
        return userDao.findById(id).get().getDeadlines();
    }

    @GetMapping(path = "/deadline/{id}")
    public Deadline getDeadlineById(@PathVariable(name = "id") Integer id) {
        return deadlineDao.findById(id).get();
    }

    @PostMapping("/testInsertDeadline")
    public void insertUtility() {
        User user = userDao.findById(1).get();
        Deadline deadline = new Deadline();
        deadline.setName("My new Deadline");
        // return user.getUsername() + " successfully registered deadline with id: " + deadline.getId().toString() ;
    }
}
