package org.example.exceptionhomework003.controller;


import org.example.exceptionhomework003.model.dto.request.AttendeeRequest;
import org.example.exceptionhomework003.model.dto.response.ApiResponse;
import org.example.exceptionhomework003.model.entity.AttendeeModel;
import org.example.exceptionhomework003.model.entity.VenueModel;
import org.example.exceptionhomework003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<AttendeeModel>> getAttendeeById(@PathVariable("attendee-id") Integer attendeeId) {
        ApiResponse<AttendeeModel> apiResponse= ApiResponse.<AttendeeModel>builder()
                .success(true)
                .message(" Get Attendee by Id successfully")
                .status(HttpStatus.OK)
                .payload(attendeeService.getAttendeeById(attendeeId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AttendeeModel>> addAttendee(@RequestBody AttendeeRequest attendeeRequest) {
        ApiResponse<AttendeeModel> apiResponse= ApiResponse.<AttendeeModel>builder()
                .success(true)
                .message(" Post a Attendee successfully")
                .status(HttpStatus.OK)
                .payload(attendeeService.addAttendee(attendeeRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<AttendeeModel>> updateAttendeeById(@PathVariable("attendee-id") Integer attendeeId, @RequestBody AttendeeRequest attendeeRequest) {
        ApiResponse<AttendeeModel> apiResponse= ApiResponse.<AttendeeModel>builder()
                .success(true)
                .message("Update Attendee by id successfully")
                .status(HttpStatus.OK)
                .payload(attendeeService.updateAttendeeById(attendeeId,attendeeRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<AttendeeModel>> deleteAttendeeById(@PathVariable("attendee-id") Integer attendeeId) {
        ApiResponse<AttendeeModel> apiResponse= ApiResponse.<AttendeeModel>builder()
                .success(true)
                .message("Delete by id successfully")
                .status(HttpStatus.OK)
                .payload(attendeeService.deleteAttendeeById(attendeeId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
