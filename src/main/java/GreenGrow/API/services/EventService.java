package GreenGrow.API.services;

import GreenGrow.API.entities.Event;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/users")
public interface EventService extends CrudService<Event> {
    List<Event> findAllByDate(LocalDate date) throws Exception;
}