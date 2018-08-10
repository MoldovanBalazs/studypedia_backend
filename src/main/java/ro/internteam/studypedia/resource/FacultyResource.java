package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.service.FacultyService;

/**
 * author: Adi
* */

@RestController
@CrossOrigin
public class FacultyResource {

    @Autowired
    private FacultyService facultyService;

    @GetMapping(path = "/faculty/all")
    public Object getFaculties(){
        return this.facultyService.getFaculties();
    }

}
