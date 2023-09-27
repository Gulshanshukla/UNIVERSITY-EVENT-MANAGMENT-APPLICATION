package com.geekster.EventManagementSystem.repo;

import com.geekster.EventManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Istudentrepo extends JpaRepository<Student,Long> {
}
