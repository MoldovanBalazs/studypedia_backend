package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.Deadline;
import org.springframework.data.repository.CrudRepository;

public interface DeadlineDao extends CrudRepository<Deadline, Integer> {
}
