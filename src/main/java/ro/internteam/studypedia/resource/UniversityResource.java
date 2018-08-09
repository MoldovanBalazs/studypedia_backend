package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.service.UniversityService;

@RestController
@CrossOrigin
public class UniversityResource {

    @Autowired
    private UniversityService universityService;

    @PostMapping(path = "/insertUniversity")
    public String insertUniversity(
            @RequestParam(name = "name") String universityName
    ){
        this.universityService.saveUniversity(universityName);
        return "added university " + universityName;
    }

    @GetMapping(path = "/university/all")
    public Object getUniversities(){
        return this.universityService.getUniversities();
    }

    @PostMapping(path = "/insertFaculty")
    public String insertFaculty(
            @RequestParam(name = "universityId") Integer universityId,
            @RequestParam(name = "faculty") String faculty
    ){
        return this.universityService.insertFaculty(universityId, faculty);
    }

}
