package ro.internteam.studypedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.dao.UniversityDao;

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

}
