package GreenGrow.API.services.impl;

import GreenGrow.API.entities.Event;
import GreenGrow.API.repositories.EventRepository;
import GreenGrow.API.services.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ImplEventService implements EventService {
    private final EventRepository eventRepository;

    public ImplEventService(EventRepository eventRepository) {

        this.eventRepository = eventRepository;
    }

    @Override
    @Transactional
    public Event save(Event event) throws Exception {
        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> findAllByDate(LocalDate date) throws Exception {
        return eventRepository.findAllByDate(date);
    }

    @Override
    public List<Event> getAll() throws Exception {
        return eventRepository.findAll();
    }
    @Override
    public Optional<Event> getById(Long id) throws Exception {
        return eventRepository.findById(id);
    }
}
