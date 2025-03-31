package org.example.exceptionhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.exceptionhomework003.model.dto.request.AttendeeRequest;
import org.example.exceptionhomework003.model.entity.AttendeeModel;
import org.example.exceptionhomework003.model.entity.EventModel;

import java.util.List;


@Mapper
public interface AttendeeRepository {

    @Select("""
      SELECT * FROM attendees;
    """)
    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId",column = "attendee_id"),
            @Result(property = "attendeeName",column = "attendee_name")
    })
    List<AttendeeModel> getAllAttendees();


    @Select("""
        SELECT * FROM attendees WHERE attendee_id = #{attendeeId};
    """)
    @ResultMap("attendeeMapper")
    AttendeeModel getAttendeeById(Integer attendeeId);


    @Select("""
      INSERT INTO attendees (attendee_name, email) VALUES (#{request.attendeeName}, #{request.email}) RETURNING *;
    """)
    @ResultMap("attendeeMapper")
    AttendeeModel addAttendee(@Param("request") AttendeeRequest attendeeRequest);


    @Select("""
       UPDATE attendees SET attendee_name = #{request.attendeeName}, email = #{request.email} WHERE attendee_id = #{attendeeId} RETURNING *;
    """)
    @ResultMap("attendeeMapper")
    AttendeeModel updateAttendeeById(Integer attendeeId,@Param("request") AttendeeRequest attendeeRequest);


    @Select("""
    DELETE FROM attendees WHERE attendee_id = #{attendeeId} RETURNING *;
    """)
    @ResultMap("attendeeMapper")
    AttendeeModel deleteAttendeeById(Integer attendeeId);


    @Select("""
      SELECT attendee_id FROM attendees WHERE attendee_id = #{attendeeId};
    """)
    List<AttendeeModel> getAttendeeByAttendeeId(Integer attendeeId);

    @Select("""
      SELECT a.* FROM attendees a INNER JOIN event_attendee ea on a.attendee_id = ea.attendee_id
      WHERE ea.event_id = #{attendeeId};
    """)
    @ResultMap("attendeeMapper")
    List<AttendeeModel> getAttendeeByEventId(Integer attendeeId);


    @Select("""
        INSERT INTO event_attendee(event_id, attendee_id) VALUES (#{eventId}, #{attendeeId});
    """)
    void addEventAttendee(Integer eventId, Integer attendeeId);


    @Select("""
        DELETE FROM event_attendee WHERE event_id = #{eventId};
    """)
    void deleteEventAttendee(Integer eventId);
}


