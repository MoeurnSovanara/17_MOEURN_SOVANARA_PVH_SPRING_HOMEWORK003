package org.example.exceptionhomework003.service;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.exceptionhomework003.model.entity.EventModel;

import java.util.List;

public interface EventService {
    List<EventModel> getAllEvents();
}
