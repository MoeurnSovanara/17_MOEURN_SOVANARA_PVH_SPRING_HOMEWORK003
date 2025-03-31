package org.example.exceptionhomework003.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventModel {
    private Integer eventId;
    private String eventName;
    private LocalDateTime eventDate;
    private VenueModel venue;
    private List<AttendeeModel> attendee;
}
