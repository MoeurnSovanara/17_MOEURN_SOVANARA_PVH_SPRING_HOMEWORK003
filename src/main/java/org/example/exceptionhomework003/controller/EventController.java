package org.example.exceptionhomework003.controller;


import org.example.exceptionhomework003.model.dto.request.EventRequest;
import org.example.exceptionhomework003.model.dto.response.ApiResponse;
import org.example.exceptionhomework003.model.entity.AttendeeModel;
import org.example.exceptionhomework003.model.entity.EventModel;
import org.example.exceptionhomework003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{event-id}")
    public ResponseEntity<ApiResponse<EventModel>> getEventById(@PathVariable("event-id") Integer eventId) {
        ApiResponse<EventModel> apiResponse= ApiResponse.<EventModel>builder()
                .success(true)
                .message("get a Event by id successfully")
                .status(HttpStatus.OK)
                .payload(eventService.getEventById(eventId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EventModel>> addEvent(@RequestBody EventRequest eventRequest) {
        ApiResponse<EventModel> apiResponse= ApiResponse.<EventModel>builder()
                .success(true)
                .message("Add a Event successfully")
                .status(HttpStatus.OK)
                .payload(eventService.addEvent(eventRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{event-id}")
    public ResponseEntity<ApiResponse<EventModel>> updateEventById(@PathVariable("event-id") Integer eventId, @RequestBody EventRequest eventRequest) {
        ApiResponse<EventModel> apiResponse= ApiResponse.<EventModel>builder()
                .success(true)
                .message("Update Event successfully")
                .status(HttpStatus.OK)
                .payload(eventService.updateEventById(eventId,eventRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{event-id}")
    public ResponseEntity<ApiResponse<EventModel>> deleteEventById(@PathVariable("event-id") Integer eventId) {
        ApiResponse<EventModel> apiResponse= ApiResponse.<EventModel>builder()
                .success(true)
                .message("Update Event successfully")
                .status(HttpStatus.OK)
                .payload(eventService.deleteEventById(eventId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
