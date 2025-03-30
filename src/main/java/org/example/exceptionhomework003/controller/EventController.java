package org.example.exceptionhomework003.controller;


import org.example.exceptionhomework003.model.dto.response.ApiResponse;
import org.example.exceptionhomework003.model.entity.AttendeeModel;
import org.example.exceptionhomework003.model.entity.EventModel;
import org.example.exceptionhomework003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EventModel>>> getAllEvents() {
        ApiResponse<List<EventModel>> apiResponse= ApiResponse.<List<EventModel>>builder()
                .success(true)
                .message("get Event successfully")
                .status(HttpStatus.OK)
                .payload(eventService.getAllEvents())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
