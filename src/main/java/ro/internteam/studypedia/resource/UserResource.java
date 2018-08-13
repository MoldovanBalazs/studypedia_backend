package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.internteam.studypedia.dao.UserDao;

@RestController
@CrossOrigin
public class UserResource {

    @Autowired
    UserDao userDao;

    //Daiana
    @GetMapping(path = "/user/all")
    public Object getUsers() {
        return userDao.findAll();
    }
}
