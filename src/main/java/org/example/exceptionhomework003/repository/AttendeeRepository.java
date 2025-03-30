package org.example.exceptionhomework003.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
}
