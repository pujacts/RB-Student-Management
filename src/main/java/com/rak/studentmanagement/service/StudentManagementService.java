package com.rak.studentmanagement.service;

import com.rak.studentmanagement.model.StudentDetailRequest;
import com.rak.studentmanagement.model.StudentResponse;

public interface StudentManagementService {
    StudentResponse createStudent(final StudentDetailRequest studentDetailRequest);
    StudentResponse deleteStudent(final Long studentId);
    StudentResponse updateStudent(final StudentDetailRequest studentDetailRequest);
    StudentResponse getAllStudents(final String school, final String grade);
    StudentResponse getStudentByIdAndSchool(final long studentId, final String school);
}
