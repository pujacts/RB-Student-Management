package com.rak.studentmanagement.service.impl;

import com.rak.studentmanagement.entity.Student;
import com.rak.studentmanagement.model.SchoolDetail;
import com.rak.studentmanagement.model.StudentDetailRequest;
import com.rak.studentmanagement.model.StudentResponse;
import com.rak.studentmanagement.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class StudentManagementHandlerTests {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentManagementHandler studentManagementHandler;

    @Test
    void testCreateStudent() {
        StudentDetailRequest request = new StudentDetailRequest();
        request.setStudentName("John Doe");
        request.setMobileNumber("1234567890");
        SchoolDetail schoolDetail = new SchoolDetail();
        schoolDetail.setSchoolName("ABC School");
        schoolDetail.setGrade("10");
        request.setSchoolDetail(schoolDetail);

        Student student = new Student();
        student.setStudentId(1L);
        student.setGrade("10");
        student.setName("John Doe");
        student.setMobileNumber("1234567890");
        student.setSchoolName("ABC School");

        given(studentRepository.save(any(Student.class))).willReturn(student);

        StudentResponse response = studentManagementHandler.createStudent(request);

        assertEquals(1, response.getStudentDetails().size());
        assertEquals("John Doe", response.getStudentDetails().get(0).getStudentName());
        assertEquals("1234567890", response.getStudentDetails().get(0).getMobileNumber());
        assertEquals("ABC School", response.getStudentDetails().get(0).getSchoolName());
        assertEquals("10", response.getStudentDetails().get(0).getGrade());
    }

    @Test
    void testRemoveStudent() {
        Student student = new Student();
        student.setStudentId(1L);
        student.setGrade("10");
        student.setName("John Doe");
        student.setMobileNumber("1234567890");
        student.setSchoolName("ABC School");

        given(studentRepository.findByStudentId(1L)).willReturn(Optional.of(student));

        StudentResponse response = studentManagementHandler.deleteStudent(1L);

        assertEquals("SUCCESS", response.getStatusMessage());
        assertEquals(204, response.getStatusCode());
    }

    @Test
    void testUpdateStudent() {
        StudentDetailRequest request = new StudentDetailRequest();
        request.setStudentId(1L);
        request.setStudentName("Jane Doe");
        request.setMobileNumber("9876543210");
        SchoolDetail schoolDetail = new SchoolDetail();
        schoolDetail.setSchoolName("XYZ School");
        schoolDetail.setGrade("12");
        request.setSchoolDetail(schoolDetail);

        Student student = new Student();
        student.setStudentId(1L);
        student.setGrade("10");
        student.setName("John Doe");
        student.setMobileNumber("1234567890");
        student.setSchoolName("ABC School");

        given(studentRepository.findByStudentId(1L)).willReturn(Optional.of(student));
        given(studentRepository.save(any(Student.class))).willReturn(student);

        StudentResponse response = studentManagementHandler.updateStudent(request);

        assertEquals("SUCCESS", response.getStatusMessage());
        assertEquals(200, response.getStatusCode());
    }

    @Test
    void testGetAllStudents() {
        Student student = new Student();
        student.setStudentId(1L);
        student.setGrade("10");
        student.setName("John Doe");
        student.setMobileNumber("1234567890");
        student.setSchoolName("ABC School");

        List<Student> students = Collections.singletonList(student);
        given(studentRepository.findBySchoolNameAndGrade("ABC School", "10")).willReturn(students);

        StudentResponse response = studentManagementHandler.getAllStudents("ABC School", "10");

        assertEquals(1, response.getStudentDetails().size());
        assertEquals("ABC School", response.getStudentDetails().get(0).getSchoolName());
        assertEquals("10", response.getStudentDetails().get(0).getGrade());
    }

    @Test
    void testGetStudentByIdAndSchool() {
        Student student = new Student();
        student.setStudentId(1L);
        student.setName("John Doe");
        student.setSchoolName("ABC School");

        given(studentRepository.findByStudentIdAndSchoolName(1L, "ABC School")).willReturn(Optional.of(student));

        StudentResponse studentResponse = studentManagementHandler.getStudentByIdAndSchool(1L, "ABC School");

        assertEquals("John Doe", studentResponse.getStudentDetails().get(0).getStudentName());
        assertEquals("ABC School", studentResponse.getStudentDetails().get(0).getSchoolName());
    }
}
