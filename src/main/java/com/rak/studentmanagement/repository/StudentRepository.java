package com.rak.studentmanagement.repository;

import com.rak.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findBySchoolNameAndGrade(String schoolName, String grade);

    Optional<Student> findByStudentId(long studentId);

    Optional<Student> findByStudentIdAndSchoolName(long studentId, String school);
}
