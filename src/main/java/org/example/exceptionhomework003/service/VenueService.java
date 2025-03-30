package org.example.exceptionhomework003.service;

import org.example.exceptionhomework003.model.entity.VenueModel;

import java.util.List;

public interface VenueService {

    List<VenueModel> getAllVenues();

    VenueModel getVenueById(Integer venueId);
}
