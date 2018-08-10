package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.model.University;
import ro.internteam.studypedia.service.UniversityService;

import java.util.ArrayList;
import java.util.List;

/*Adi*/
@RestController
@CrossOrigin
public class UniversityResource {

    @Autowired
    private UniversityService universityService;

    @PostMapping(path = "/insertUniversity")
    public String insertUniversity(
            @RequestBody University newUniversity
            ){
        this.universityService.saveUniversity(newUniversity);
        return "added university " + newUniversity.getName();
    }

    @GetMapping(path = "/university/{id}")
    public Object getUniversityById(@PathVariable("id") Integer id){
        return this.universityService.getUniversityById(id);
    }

    @GetMapping(path = "/university/all")
    public Object getUniversities(@RequestParam("param") String param ){

        if(param == null){return null;}
        List<University> universities =  new ArrayList<>();
        for(University university : universityService.getUniversities()){
            if(university.getName().contains(param)){
                universities.add(university);
            }
        }
        return universities;
    }

    @PutMapping(path = "/updateUniversities")
    public String insertFaculty(
            @RequestParam(name = "universityId") Integer universityId,
            @RequestParam(name = "faculty") String faculty
    ){
        return this.universityService.insertFaculty(universityId, faculty);
    }

}
