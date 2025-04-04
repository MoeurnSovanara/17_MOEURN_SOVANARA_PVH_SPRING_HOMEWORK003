package org.example.exceptionhomework003.service.impl;

import org.example.exceptionhomework003.model.dto.request.VenueRequest;
import org.example.exceptionhomework003.model.dto.response.VenueDTO;
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
    public List<VenueModel> getAllVenues(Integer page, Integer size) {
        return venueRepository.getAllVenues(page,size);
    }

    @Override
    public VenueModel getVenueById(Integer venueId) {
        return venueRepository.getVenueById(venueId);
    }

    @Override
    public VenueDTO addVenue(VenueRequest venueRequest) {
        return venueRepository.addVenue(venueRequest);
    }

    @Override
    public VenueModel updateVenueById(Integer venueId, VenueRequest venueRequest) {
        return venueRepository.updateVenueById(venueId,venueRequest);
    }

    @Override
    public VenueModel deleteVenueById(Integer venueId) {
        return venueRepository.deleteVenueById(venueId);
    }
}
