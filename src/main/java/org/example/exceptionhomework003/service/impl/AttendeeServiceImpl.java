package org.example.exceptionhomework003.service.impl;

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
    public List<AttendeeModel> getAllAttendees() {
        return attendeeRepository.getAllAttendees();
    }
}
