package ro.internteam.studypedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.SubjectDao;

@RestController
@CrossOrigin
public class SubjectService {
    @Autowired
    SubjectDao subjectDao;

    @GetMapping(path = "/subject/all")
    public Object getSubjects() {
        return subjectDao.findAll();
    }

}
