package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.University;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UniversityDao extends CrudRepository<University, Integer> {
    List<University> findAllByNameStartsWith(String name);
}
