package org.example.exceptionhomework003.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueModel {
    private Integer venueId;
    private  String venueName;
    private String location;
}
