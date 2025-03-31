package org.example.exceptionhomework003.service.impl;

import org.example.exceptionhomework003.model.dto.request.EventRequest;
import org.example.exceptionhomework003.model.entity.EventModel;
import org.example.exceptionhomework003.repository.AttendeeRepository;
import org.example.exceptionhomework003.repository.EventRepository;
import org.example.exceptionhomework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public EventServiceImpl(EventRepository eventRepository, AttendeeRepository attendeeRepository) {
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<EventModel> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    @Override
    public EventModel getEventById(Integer eventId) {
        return eventRepository.getEventById(eventId);
    }

    @Override
    public EventModel addEvent(EventRequest eventRequest) {
        EventModel eventModel = eventRepository.addEvent(eventRequest);

        for(Integer attendeeId : eventRequest.getAttendee()){
            attendeeRepository.addEventAttendee(eventModel.getEventId(), attendeeId);
        }
        return eventRepository.getEventById(eventModel.getEventId());
    }

    @Override
    public EventModel updateEventById(Integer eventId, EventRequest eventRequest) {
        eventRepository.updateEventById(eventId, eventRequest);
        attendeeRepository.deleteEventAttendee(eventId);
        for (Integer attendeeId : eventRequest.getAttendee()){
            attendeeRepository.addEventAttendee(eventId, attendeeId);
        }
        return eventRepository.updateEventById(eventId,eventRequest);
    }

    @Override
    public EventModel deleteEventById(Integer eventId) {

            return eventRepository.deleteEventById(eventId);
    }
}
