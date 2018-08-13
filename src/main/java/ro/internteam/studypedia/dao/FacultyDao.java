package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.Faculty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author I. Stetco
 */
public interface FacultyDao extends CrudRepository<Faculty, Integer> {

    public List<Faculty> findAllByUniversityId(Integer universityId);

}
