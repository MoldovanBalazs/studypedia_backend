package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.model.Faculty;
import ro.internteam.studypedia.model.University;
import ro.internteam.studypedia.service.FacultyService;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(path = "/getFacultiesByUniversityId")
    public Object getFacultiesByUniversityId(
            @RequestParam(name = "universityId") Integer universityId
    ){
        if(universityId == null){
            return  null;
        }
        List<Faculty> faculties = new ArrayList<>();
        for(Faculty faculty: this.facultyService.getFaculties()){
            if(universityId == faculty.getUniversity().getId()){
                System.out.println(faculty.getName());
                faculties.add(faculty);
            }
        }
        return faculties;
    }

    @PostMapping(path = "/insertFaculty")
    public String insertFaculty(
            @RequestBody Faculty newFaculty
    ){
        this.facultyService.insertFaculty(newFaculty);
        return "";
    }

}
