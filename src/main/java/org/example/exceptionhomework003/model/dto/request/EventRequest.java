package org.example.exceptionhomework003.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exceptionhomework003.model.entity.AttendeeModel;
import org.example.exceptionhomework003.model.entity.VenueModel;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String eventName;
    private String eventDate;
    private VenueModel venue;
}
