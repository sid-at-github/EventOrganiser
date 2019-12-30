package projects.cloud.EventOrganiser.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projects.cloud.EventOrganiser.daos.EventAttendeeDao;
import projects.cloud.EventOrganiser.daos.EventDao;
import projects.cloud.EventOrganiser.dtos.EventRequestDto;
import projects.cloud.EventOrganiser.dtos.ResponseDto;
import projects.cloud.EventOrganiser.models.Event;
import projects.cloud.EventOrganiser.models.EventAttendee;

@RestController
public class EventResource {

	@Autowired
	private EventDao eventDao;

	@Autowired
	private EventAttendeeDao eventAttendeeDao;

	@PostMapping("/event")
	public ResponseDto createOrEditEvent(@RequestBody Event event) {
		eventDao.save(event);
		return new ResponseDto("success");
	}

	@GetMapping("/event")
	public List<Event> getEventList(EventRequestDto eventRequestDto) {
		if (eventRequestDto.getOrganiserEmail() != null) {
			return eventDao.findByOrganiserEmail(eventRequestDto.getOrganiserEmail());
		}
		List<EventAttendee> eventAttendeeList = eventAttendeeDao.findByAttendeeEmail(eventRequestDto.getUser());
		List<Long> idList = new ArrayList<>();
		for (EventAttendee eventAttendee : eventAttendeeList) {
			idList.add(eventAttendee.getEventId());
		}
		if (eventRequestDto.getTitle() == null) {
			return eventDao.findByIdIn(idList);
		}
		return eventDao.findByIdInAndTitleIgnoreCaseContaining(idList, eventRequestDto.getTitle());
	}

	@PostMapping("/event/{eventId}")
	public void deleteEvent(@PathVariable long eventId) {
		eventDao.deleteById(eventId);
	}

	@PostMapping("/attendee")
	public ResponseDto addAttendee(@RequestBody EventAttendee eventAttendee) {
		eventAttendeeDao.save(eventAttendee);
		return new ResponseDto("success");
	}

	@PutMapping("/event/{eventId}")
	public ResponseDto archiveUnarchiveEvent(@PathVariable long eventId, @RequestBody Event editedEvent) {
		Event event = eventDao.findById(eventId).get();
		event.setArchived(editedEvent.isArchived());
		eventDao.save(event);
		return new ResponseDto("success");
	}

	@GetMapping("/event/{eventId}")
	public Event getEventDetail(@PathVariable long eventId) {
		return eventDao.findById(eventId).get();
	}
}
