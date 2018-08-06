package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectDao extends CrudRepository<Subject, Integer> {
}
