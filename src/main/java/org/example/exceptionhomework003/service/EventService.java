package org.example.exceptionhomework003.service;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.exceptionhomework003.model.dto.request.EventRequest;
import org.example.exceptionhomework003.model.entity.EventModel;

import java.util.List;

public interface EventService {
    List<EventModel> getAllEvents(Integer page, Integer size);

    EventModel getEventById(Integer eventId);

    EventModel addEvent(EventRequest eventRequest);

    EventModel updateEventById(Integer eventId, EventRequest eventRequest);

    EventModel deleteEventById(Integer eventId);
}
