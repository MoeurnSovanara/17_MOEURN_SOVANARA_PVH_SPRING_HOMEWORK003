package org.example.exceptionhomework003.service.impl;

import org.example.exceptionhomework003.exception.NotFoundException;
import org.example.exceptionhomework003.model.dto.request.AttendeeRequest;
import org.example.exceptionhomework003.model.entity.AttendeeModel;
import org.example.exceptionhomework003.repository.AttendeeRepository;
import org.example.exceptionhomework003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<AttendeeModel> getAllAttendees(Integer page, Integer size) {
        return attendeeRepository.getAllAttendees(page,size);
    }

    @Override
    public AttendeeModel getAttendeeById(Integer attendeeId) {

       if (attendeeRepository.getAttendeeById(attendeeId) ==  null){
         throw new NotFoundException("Attendee"+ attendeeId +" not found");
       }
        return attendeeRepository.getAttendeeById(attendeeId);
    }

    @Override
    public AttendeeModel addAttendee(AttendeeRequest attendeeRequest) {
            return attendeeRepository.addAttendee(attendeeRequest);
    }

    @Override
    public AttendeeModel updateAttendeeById(Integer attendeeId, AttendeeRequest attendeeRequest) {
            return attendeeRepository.updateAttendeeById(attendeeId,attendeeRequest);
    }

    @Override
    public AttendeeModel deleteAttendeeById(Integer attendeeId) {
        return attendeeRepository.deleteAttendeeById(attendeeId);
    }
}
