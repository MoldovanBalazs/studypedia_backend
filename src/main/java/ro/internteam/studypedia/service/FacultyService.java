package ro.internteam.studypedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.dao.UniversityDao;
import ro.internteam.studypedia.model.Faculty;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Adi;
 * */
@Service
public class FacultyService {

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private UniversityDao universityDao;

    /**Adi*/
    public Iterable<Faculty> getFaculties() {
        return this.facultyDao.findAll();
    }

    /**Adi*/
    public Faculty insertFaculty(Faculty newFaculty){
        return this.facultyDao.save(newFaculty);
    }

}
