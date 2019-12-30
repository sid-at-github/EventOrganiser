package projects.cloud.EventOrganiser.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projects.cloud.EventOrganiser.models.Event;

@Repository
public interface EventDao extends CrudRepository<Event, Long> {

	public List<Event> findByOrganiserEmail(String organiserEmail);

	public List<Event> findByIdInAndTitleIgnoreCaseContaining(List<Long> idList, String title);

	public List<Event> findByIdIn(List<Long> idList);
}
