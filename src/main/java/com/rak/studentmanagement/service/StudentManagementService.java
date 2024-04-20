package com.rak.studentmanagement.service;

import com.rak.studentmanagement.model.StudentDto;
import com.rak.studentmanagement.model.StudentRequestDto;

import java.util.List;

public interface StudentManagementService {
    StudentDto createStudent(final StudentRequestDto studentDetailRequest);

    StudentDto deleteStudent(final Long studentId);

    StudentDto updateStudent(final StudentRequestDto studentDetailRequest);

    List<StudentDto> getAllStudents(final String schoolname, final String grade);

    StudentDto getStudentByIdAndSchool(final long studentId, final String schoolName);
}
