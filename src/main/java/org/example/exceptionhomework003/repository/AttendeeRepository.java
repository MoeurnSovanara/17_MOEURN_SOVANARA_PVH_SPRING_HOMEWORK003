package org.example.exceptionhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.exceptionhomework003.model.dto.request.AttendeeRequest;
import org.example.exceptionhomework003.model.entity.AttendeeModel;

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
}
