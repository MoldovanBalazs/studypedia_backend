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

    public void saveUniversity(University newUniversity) {
        this.universityDao.save(newUniversity);
    }

    public Iterable<University> getUniversities() {
        return this.universityDao.findAll();
    }

    public String insertFaculty(Integer universityId, String facultyName) {
        University newUniversity = this.universityDao.findById(universityId).orElse(null);
        if (newUniversity != null) {
            Faculty newFaculty = new Faculty();
            newFaculty.setName(facultyName);
            newUniversity.insertFaculty(newFaculty);
            return "added faculty " + facultyName;
        }
        return "University with id = " + universityId + " doesn't exist";
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
