package com.geekster.EventManagementSystem.controller;

import com.geekster.EventManagementSystem.model.Event;
import com.geekster.EventManagementSystem.service.Eventservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated

public class Eventcontroller {
    @Autowired
    Eventservice eventservice;
    //1.add events
    @PostMapping("events")
    public String addevents(@RequestBody @Valid List<Event> newevents)
    {
        return eventservice.addEvents(newevents);
    }
    ///2. delete events
    @DeleteMapping("remove/ids")
    public String deleteeventsbyids(@RequestBody List<Long> ids)
    {
        return eventservice.removeEventsByIds(ids);
    }
    //3. get all events by date by custom finder
    @GetMapping("eventby/Date")
    public List<Event> getEventsByDate(@RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date); // Convert the date string to LocalDate
        return eventservice.getAllEventsByDate(localDate);

    }
    /// 4.update event
    @PutMapping("event/eventId/{eventId}")
    public Event updateEvent(@PathVariable Long eventId, @RequestBody Event updatedEvent) {
        return eventservice.updateEvent(eventId, updatedEvent);
    }


}
