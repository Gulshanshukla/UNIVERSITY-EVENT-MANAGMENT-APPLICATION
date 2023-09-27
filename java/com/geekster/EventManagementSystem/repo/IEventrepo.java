package com.geekster.EventManagementSystem.repo;

import com.geekster.EventManagementSystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface IEventrepo extends JpaRepository<Event,Long> {
    List<Event> findAllByDate(LocalDate localDate);
}
