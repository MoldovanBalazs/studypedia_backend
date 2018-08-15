package ro.internteam.studypedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.dao.UniversityDao;

import ro.internteam.studypedia.model.Faculty;
import ro.internteam.studypedia.model.University;

/**
 * author: Adi;
 * */
@Service
public class FacultyService {

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private UniversityDao universityDao;

    public Object getFaculties(){
        return this.facultyDao.findAll();
    }

    public void saveFaculty(String facultyName, University university){
        Faculty newFaculty = new Faculty();
        newFaculty.setName(facultyName);
        newFaculty.setUniversity(university);
        this.facultyDao.save(newFaculty);
    }

    @GetMapping(path = "/{university}/faculties")
    public Object getFacultiesByUniversity(@PathVariable Integer university)
    {
        return facultyDao.findAllByUniversityId(university);
    }

    @GetMapping(path = "/faculties")
    public Object test()
    {

        return universityDao.findById(6);
    }



}
