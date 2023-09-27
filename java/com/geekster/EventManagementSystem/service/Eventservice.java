package com.geekster.EventManagementSystem.service;

import com.geekster.EventManagementSystem.model.Event;
import com.geekster.EventManagementSystem.repo.IEventrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class Eventservice {
    @Autowired
    IEventrepo iEventrepo;

    public String addEvents(List<Event> newevents) {
        iEventrepo.saveAll(newevents);
        return newevents.size()+" event added";
    }

    public String removeEventsByIds(List<Long> ids) {
         iEventrepo.deleteAllById(ids);
         return " event removed";
    }

    public List<Event> getAllEventsByDate(LocalDate localDate) {
        return iEventrepo.findAllByDate(localDate);
    }
}
