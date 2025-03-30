package org.example.exceptionhomework003.service.impl;

import org.example.exceptionhomework003.model.dto.request.VenueRequest;
import org.example.exceptionhomework003.model.entity.VenueModel;
import org.example.exceptionhomework003.repository.VenueRepository;
import org.example.exceptionhomework003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServoiceimpl implements VenueService {
    private final VenueRepository venueRepository;

    public VenueServoiceimpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<VenueModel> getAllVenues() {
        return venueRepository.getAllVenues();
    }

    @Override
    public VenueModel getVenueById(Integer venueId) {
        return venueRepository.getVenueById(venueId);
    }

    @Override
    public VenueModel addVenue(VenueRequest venueRequest) {
        return venueRepository.addVenue(venueRequest);
    }
}
