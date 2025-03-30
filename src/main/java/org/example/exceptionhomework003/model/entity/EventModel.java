package org.example.exceptionhomework003.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Select;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventModel {
    private Integer eventId;
    private String eventName;
    private String eventDate;
    private VenueModel venue;
}
