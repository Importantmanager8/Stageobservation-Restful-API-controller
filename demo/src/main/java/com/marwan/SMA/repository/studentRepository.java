package com.marwan.SMA.repository;

import com.marwan.SMA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Student, Long> {


}
