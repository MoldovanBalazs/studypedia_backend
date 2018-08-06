package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.Faculty;
import org.springframework.data.repository.CrudRepository;

/**
 * @author I. Stetco
 */
public interface FacultyDao extends CrudRepository<Faculty, Integer> {
}
