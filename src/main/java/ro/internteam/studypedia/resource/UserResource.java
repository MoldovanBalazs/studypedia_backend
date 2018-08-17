package ro.internteam.studypedia.resource;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.*;
import ro.internteam.studypedia.service.UserService;

import java.util.List;

@RestController
@CrossOrigin
public class UserResource {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    //Daiana
    @GetMapping(path = "/user/all")
    public Iterable<User> getUsers() {
        return userDao.findAll();
    }

    @GetMapping(path = "/valid/{username}")
    public boolean checkValidUsername(@PathVariable String username) {
        User user = this.userDao.findAllByUsername(username);
        if(user != null) {
            return false;
        }
        return true;
    }

    @GetMapping(path = "/validate/{userLog}")
    public User verifyLogin(@PathVariable String userLog) {
        ObjectMapper mapper = new ObjectMapper();
        UserLog local = new UserLog();
        try{
            local = mapper.readValue(userLog, UserLog.class);
        }catch (Exception e) {
            return null;
        }

        User user = null;

        try{
            user = userDao.findAllByUsername(local.getUsername());
        }catch(NullPointerException e) {
            return null;
        }

        if(user != null) {
            if (user.getPassword().equals(local.getPassword())) {
                User safeUser = new User();
                safeUser.setId(user.getId());
                safeUser.setName(user.getName());
                safeUser.setUsername(user.getUsername());
                safeUser.setPassword("");
                safeUser.setUniversity(user.getUniversity());
                safeUser.setFaculty(user.getFaculty());
                safeUser.setBranch(user.getBranch());
                safeUser.setUserType(user.getUserType());

                return user;
            }
        }

        return null;
    }


    @PostMapping(path = "/insert/user")
    public Object insertUser(@RequestBody String user){
        ObjectMapper mapper = new ObjectMapper();
        User newUser = new User();
        try {
            newUser = mapper.readValue(user, User.class);
        } catch (Exception e) {
            return null;
        }

        if(newUser != null) {
            return this.userDao.save(newUser);
        }
        return null;
    }

//    @GetMapping(path = "/testtt")
//    public User verifyLogin2() {
//        UserLog userLog = new UserLog();
//        userLog.setUsername("testUser");
//        userLog.setPassword("tehst");
//
//        return verifyLogin(userLog);
//    }



}

