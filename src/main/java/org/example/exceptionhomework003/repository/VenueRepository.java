package org.example.exceptionhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.exceptionhomework003.model.entity.VenueModel;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Select("""
      SELECT * FROM venues;
    """)
    @Results(id = "venueMapper", value = {
            @Result(property = "venueId",column = "venue_id"),
            @Result(property = "venueName",column = "venue_name")
    })
    List<VenueModel> getAllVenues();
}
