package org.example.exceptionhomework003.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueRequest {
    private  String venueName;
    private String location;
}
