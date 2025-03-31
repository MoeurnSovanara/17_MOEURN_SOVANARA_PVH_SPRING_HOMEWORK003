package org.example.exceptionhomework003.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exceptionhomework003.model.entity.AttendeeModel;
import org.example.exceptionhomework003.model.entity.VenueModel;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String eventName;
    private LocalDateTime eventDate;
    private Integer venue;
    private List<Integer> attendee;
}
