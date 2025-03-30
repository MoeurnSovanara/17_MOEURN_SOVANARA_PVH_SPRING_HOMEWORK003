package org.example.exceptionhomework003.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeModel {
    private Integer attendeeId;
    private String attendeeName;
    private String email;
}
