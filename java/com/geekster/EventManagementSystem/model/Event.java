package com.geekster.EventManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @NotNull
    private Long eventId;

    @NotBlank
    private String eventName;

    @NotBlank
    private String locationOfEvent;

    @NotNull
    @FutureOrPresent
    private LocalDate date;

    @NotNull
    @Future
    private LocalTime startTime;

    @NotNull
    @Future
    private LocalTime endTime;

}
