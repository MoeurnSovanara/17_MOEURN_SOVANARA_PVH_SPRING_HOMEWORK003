package org.example.exceptionhomework003.model.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueDTO {
    private Integer venueId;
    private  String venueName;
    private String location;
}
