package ro.internteam.studypedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.*;
import ro.internteam.studypedia.model.UserType;

import java.util.List;

@RestController
@CrossOrigin
public class UserService {

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "authentication/{userLog}")
    public boolean verifyLogin(@PathVariable UserLog userLog) {
        User user = userDao.findAllByUsername(userLog.getUsername());
        if(!user.equals(null)) {
            if(userLog.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    @GetMapping(path = "/uthentication")
    public String test() {
        User user = userDao.findById(1).get();
//        if(verifyLogin("ionbo$$", "piscutza")){
//            return "alright";
//        }

        return "oops";
    }

    public void saveUser(String fullName, String username, String password, University university, Faculty faculty, Branch branch, UserType userType){
        User newUser = new User();
        newUser.setName(fullName);
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setUniversity(university);
        newUser.setFaculty(faculty);
        newUser.setBranch(branch);
        newUser.setUserType(userType);
        this.userDao.save(newUser);
    }



}