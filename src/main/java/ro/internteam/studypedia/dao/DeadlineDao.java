package ro.internteam.studypedia.dao;

import ro.internteam.studypedia.model.Deadline;
import org.springframework.data.repository.CrudRepository;
import ro.internteam.studypedia.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface DeadlineDao extends CrudRepository<Deadline, Integer> {

//    List<Deadline> findAllByDateAfterOrderByDateAsc(LocalDateTime localDateTime);
//
//    List<Deadline> findAllByUserEqualsAndDateAfter(User user, LocalDateTime localDateTime);
//
//    List<Deadline> findAllByUserAndDateAfter(User user, LocalDateTime localDateTime);
//
//    List<Deadline> findDeadlinesByUserAndDateAfterOrderByDate(User user, LocalDateTime localDateTime);

    public List<Deadline> findAllByUserEqualsAndDateAfterOrderByDate(User user, LocalDateTime localDateTime);

    List<Deadline> findAllByUserAndDateIsAfter(User user, LocalDateTime localDateTime);

}


