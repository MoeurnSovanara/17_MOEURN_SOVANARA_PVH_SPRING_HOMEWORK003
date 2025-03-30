package org.example.exceptionhomework003.repository;


import org.apache.ibatis.annotations.*;
import org.example.exceptionhomework003.model.entity.EventModel;

import java.util.List;

@Mapper
public interface EventRepository {

    @Select("""
      SELECT e.* FROM events e INNER JOIN public.event_attendee ea on e.venue_id = e.venue_id
      WHERE e.venue_id= #{venueId}
    """)

    List<EventModel> getVenueByEventId(Integer venueId);
    @Select("""
     SELECT * FROM events;
    """)
    @Results(id = "eventMapper",value = {
            @Result(property = "eventId",column = "event_id"),
            @Result(property = "eventName",column = "event_name"),

            @Result(property = "eventDate",column = "event_date"),
            @Result(property = "venue",column = "venue_id",one=@One(select = "getVenueByEventId"))
    })
    List<EventModel> getAllEvents();
}
