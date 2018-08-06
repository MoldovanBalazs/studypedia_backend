package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityDao extends CrudRepository<University, Integer> {
}
