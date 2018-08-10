package ro.internteam.studypedia.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.internteam.studypedia.dao.SubjectDao;
import ro.internteam.studypedia.dao.UserDao;

@RestController
@CrossOrigin
public class SubjectResource {

    @Autowired
    SubjectDao subjectDao;

    //Daiana
    @GetMapping(path = "/subject/all")
    public Object getSubjects() {
        return subjectDao.findAll();
    }
}
