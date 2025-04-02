package org.example.exceptionhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.exceptionhomework003.model.dto.request.VenueRequest;
import org.example.exceptionhomework003.model.dto.response.VenueDTO;
import org.example.exceptionhomework003.model.entity.VenueModel;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Select("""
      SELECT * FROM venues
      OFFSET #{page}
      LIMIT #{size}
    """)
    @Results(id = "venueMapper", value = {
            @Result(property = "venueId",column = "venue_id"),
            @Result(property = "venueName",column = "venue_name")
    })
    List<VenueModel> getAllVenues(Integer page, Integer size);


    @Select("""
        SELECT * FROM venues
        WHERE venue_id = #{venueId};
    """)
    @ResultMap("venueMapper")
    VenueModel getVenueById(Integer venueId);


    @Select("""
        INSERT INTO venues (venue_name, location) VALUES (#{request.venueName}, #{request.location})
        RETURNING *
    """)
    @ResultMap("venueMapper")
    VenueDTO addVenue(@Param("request") VenueRequest venueRequest);


    @Select("""
        UPDATE venues SET venue_name= #{request.venueName}, location = #{request.location} WHERE venue_id = #{venueId} RETURNING *;
    """)
    @ResultMap("venueMapper")
    VenueModel updateVenueById(Integer venueId,@Param("request")VenueRequest venueRequest);



    @Select("""
       Delete FROM venues WHERE venue_id = #{venueId} RETURNING *;
    """)
    @ResultMap("venueMapper")
    VenueModel deleteVenueById(Integer venueId);
}
