package org.example.exceptionhomework003.service;


import org.example.exceptionhomework003.model.dto.request.AttendeeRequest;
import org.example.exceptionhomework003.model.entity.AttendeeModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AttendeeService {
    List<AttendeeModel> getAllAttendees();

    AttendeeModel getAttendeeById(Integer attendeeId);

    AttendeeModel addAttendee(AttendeeRequest attendeeRequest);

    AttendeeModel updateAttendeeById(Integer attendeeId, AttendeeRequest attendeeRequest);

    AttendeeModel deleteAttendeeById(Integer attendeeId);
}
