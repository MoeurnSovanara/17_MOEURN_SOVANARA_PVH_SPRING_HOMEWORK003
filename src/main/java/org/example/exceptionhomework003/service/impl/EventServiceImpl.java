package org.example.exceptionhomework003.service.impl;

import org.example.exceptionhomework003.model.entity.EventModel;
import org.example.exceptionhomework003.repository.EventRepository;
import org.example.exceptionhomework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventModel> getAllEvents() {
        return eventRepository.getAllEvents();
    }
}
