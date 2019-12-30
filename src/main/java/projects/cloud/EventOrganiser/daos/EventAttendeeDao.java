package projects.cloud.EventOrganiser.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projects.cloud.EventOrganiser.models.EventAttendee;

@Repository
public interface EventAttendeeDao extends CrudRepository<EventAttendee, Long> {

	public List<EventAttendee> findByAttendeeEmail(String attendeeEmail);

}
