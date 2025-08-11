package ac.routes;

import ac.controllers.EventController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@Configuration
@RequestMapping("/api/events")
public class EventRoutes {

    private final EventController eventController;

    @Autowired
    public EventRoutes(EventController eventController) {
        this.eventController = eventController;
    }

    @PostMapping
    public void createEvent(@RequestBody Event event) {
        eventController.createEvent(event);
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventController.getEvent(id);
    }

    @PutMapping("/{id}")
    public void updateEvent(@PathVariable Long id, @RequestBody Event event) {
        eventController.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventController.deleteEvent(id);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventController.getAllEvents();
    }
}