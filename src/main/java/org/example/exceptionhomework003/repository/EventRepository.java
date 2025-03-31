package org.example.exceptionhomework003.repository;


import org.apache.ibatis.annotations.*;
import org.example.exceptionhomework003.model.dto.request.EventRequest;
import org.example.exceptionhomework003.model.entity.EventModel;

import java.util.List;

@Mapper
public interface EventRepository {



    @Select("""
     SELECT * FROM events;
    """)
    @Results(id = "eventMapper",value = {
            @Result(property = "eventId",column = "event_id"),
            @Result(property = "eventName",column = "event_name"),
            @Result(property = "eventDate",column = "event_date"),
            @Result(property = "venue",column = "venue_id",
                    one=@One(select = "org.example.exceptionhomework003.repository.VenueRepository.getVenueById")),
            @Result(property = "attendee", column = "event_id",
                    many = @Many(select = "org.example.exceptionhomework003.repository.AttendeeRepository.getAttendeeByEventId"))
    })
    List<EventModel> getAllEvents();


    @Select("""
        SELECT * FROM events WHERE event_id=#{eventId}
    """)
    @ResultMap("eventMapper")
    EventModel getEventById(Integer eventId);


    @Select("""
        INSERT INTO events(event_name, event_date, venue_id)
        VALUES (#{request.eventName}, #{request.eventDate}, #{request.venue}) RETURNING *;
    """)
    @ResultMap("eventMapper")
    EventModel addEvent(@Param("request") EventRequest eventRequest);



    @Select("""
        UPDATE events SET event_name= #{request.eventName},venue_id = #{request.venue} WHERE event_id=#{eventId} RETURNING *;
    """)
    @ResultMap("eventMapper")
    EventModel updateEventById(Integer eventId,@Param("request")EventRequest eventRequest);


    @Select("""
        DELETE FROM events WHERE event_id=#{eventId} RETURNING *;
    """)
    @ResultMap("eventMapper")
    EventModel deleteEventById(Integer eventId);
}
