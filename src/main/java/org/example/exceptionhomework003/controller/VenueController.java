package org.example.exceptionhomework003.controller;
import org.example.exceptionhomework003.model.dto.request.VenueRequest;
import org.example.exceptionhomework003.model.dto.response.ApiResponse;
import org.example.exceptionhomework003.model.entity.VenueModel;
import org.example.exceptionhomework003.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {
    private final VenueService venueService;
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VenueModel>>>  getAllVenues() {
        ApiResponse<List<VenueModel>> apiResponse= ApiResponse.<List<VenueModel>>builder()
                .success(true)
                .message("Get all Venue successfully")
                .status(HttpStatus.OK)
                .payload(venueService.getAllVenues())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<VenueModel>> getVenueById(@PathVariable("venue-id") Integer venueId) {
        ApiResponse<VenueModel> apiResponse= ApiResponse.<VenueModel>builder()
                .success(true)
                .message("Get venue by id successfully")
                .status(HttpStatus.OK)
                .payload(venueService.getVenueById(venueId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


    @PostMapping
    public ResponseEntity<ApiResponse<VenueModel>> addVenue(@RequestBody VenueRequest venueRequest) {
        ApiResponse<VenueModel> apiResponse= ApiResponse.<VenueModel>builder()
                .success(true)
                .message("Add a venue successfully")
                .status(HttpStatus.OK)
                .payload(venueService.addVenue(venueRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
