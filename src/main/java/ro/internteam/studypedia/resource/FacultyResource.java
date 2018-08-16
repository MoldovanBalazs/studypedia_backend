package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.service.FacultyService;

import ro.internteam.studypedia.model.Faculty;
import ro.internteam.studypedia.model.University;

import java.util.List;

/**
 * author: Adi
* */

@RestController
@CrossOrigin
public class FacultyResource {

    @Autowired
    private FacultyService facultyService;
    @Autowired
    private FacultyDao facultyDao;

    @GetMapping(path = "/faculty/all")
    public Object getFaculties(){
        return this.facultyService.getFaculties();
    }

   /* @GetMapping(path = "faculty/name")
    public Object getFacultiesByName()*/

   @GetMapping(path = "/{university}/faculties")
   public List<Faculty> getFacultyByUniversity(@PathVariable Integer university) {
       return this.facultyDao.findAllByUniversityId(university);
   }

    @PostMapping(path = "/insertNewFaculty")
    public void insertFaculty(
            @RequestParam(name = "facultyName") String facultyName,
            @RequestParam(name = "university_id") University university_id

    ){
        this.facultyService.saveFaculty(facultyName, university_id);
    }
}
