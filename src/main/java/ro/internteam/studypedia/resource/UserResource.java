package ro.internteam.studypedia.resource;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.UserDao;
import ro.internteam.studypedia.model.*;
import ro.internteam.studypedia.service.UserService;

@RestController
@CrossOrigin
public class UserResource {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    //Daiana
    @GetMapping(path = "/user/all")
    public Object getUsers() {
        return userDao.findAll();
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

                return safeUser;
            }
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



    @PostMapping(path = "/insertUser")
    public void insertUser(
            @RequestParam(name = "name") String fullName,
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "university") University university,
            @RequestParam(name = "faculty") Faculty faculty,
            @RequestParam(name = "branch") Branch branch,
            @RequestParam(name = "userType") UserType userType

    ){
        this.userService.saveUser(fullName, username, password, university, faculty, branch, userType);
    }
}

