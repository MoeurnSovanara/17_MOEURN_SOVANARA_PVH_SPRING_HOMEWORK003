package org.example.exceptionhomework003.controller;


import org.example.exceptionhomework003.model.dto.response.ApiResponse;
import org.example.exceptionhomework003.model.entity.AttendeeModel;
import org.example.exceptionhomework003.model.entity.VenueModel;
import org.example.exceptionhomework003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {

    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AttendeeModel>>> getAllAttendees() {
        ApiResponse<List<AttendeeModel>> apiResponse= ApiResponse.<List<AttendeeModel>>builder()
                .success(true)
                .message(" Get all Attendee successfully")
                .status(HttpStatus.OK)
                .payload(attendeeService.getAllAttendees())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
