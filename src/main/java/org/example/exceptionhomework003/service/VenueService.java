package org.example.exceptionhomework003.service;

import org.example.exceptionhomework003.model.dto.request.VenueRequest;
import org.example.exceptionhomework003.model.dto.response.VenueDTO;
import org.example.exceptionhomework003.model.entity.VenueModel;

import java.util.List;

public interface VenueService {

    List<VenueModel> getAllVenues(Integer page, Integer size);

    VenueModel getVenueById(Integer venueId);

    VenueDTO addVenue(VenueRequest venueRequest);

    VenueModel updateVenueById(Integer venueId, VenueRequest venueRequest);

    VenueModel deleteVenueById(Integer venueId);
}
