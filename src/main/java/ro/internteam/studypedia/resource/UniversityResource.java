package ro.internteam.studypedia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.internteam.studypedia.model.Faculty;
import ro.internteam.studypedia.model.University;
import ro.internteam.studypedia.service.FacultyService;
import ro.internteam.studypedia.service.UniversityService;

import java.util.ArrayList;
import java.util.List;

/*Adi*/
@RestController
@CrossOrigin
public class UniversityResource {

    @Autowired
    private UniversityService universityService;

    @Autowired
    private FacultyService facultyService;

    /**Adi*/
    @PostMapping(path = "/insertUniversity")
    public String insertUniversity(
            @RequestBody University newUniversity
            ){
        /*List<Faculty> faculties = new ArrayList<>();
        newUniversity.getFaculties().forEach(f -> faculties.add(facultyService.insertFaculty(f)));
        newUniversity.getFaculties().clear();
        newUniversity.getFaculties().addAll(faculties);*/
        University university = this.universityService.saveUniversity(newUniversity);
        /*faculties.forEach(f -> {
            f.setUniversity(university);
            //facultyService.insertFaculty(f);
        });*/
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

}
