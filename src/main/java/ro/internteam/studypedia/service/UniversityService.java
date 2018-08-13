package ro.internteam.studypedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import ro.internteam.studypedia.dao.FacultyDao;
import ro.internteam.studypedia.dao.UniversityDao;
import ro.internteam.studypedia.model.Faculty;
import ro.internteam.studypedia.model.University;

import java.util.List;

@Service
public class UniversityService {

    @Autowired
    private UniversityDao universityDao;

    @Autowired
    private FacultyDao facultyDao;

    /**Adi*/
    public University saveUniversity(University newUniversity) {
        return this.universityDao.save(newUniversity);
    }

    /**Adi*/
    public Iterable<University> getUniversities() {
        return this.universityDao.findAll();
    }

    /**
     * Adi
     */
    public Object getFaculties(Integer universityId) {
        return "";
    }

    /**
     * Adi
     */
    public Object getUniversityById(Integer universityId) {
        University university = this.universityDao.findById(universityId).orElse(null);
        return university;
    }

    public List<University> findUniversities(String name) {
        return universityDao.findAllByNameStartsWith(name);
    }

}
