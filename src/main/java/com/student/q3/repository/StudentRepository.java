package com.student.q3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.q3.model.Student;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {

}