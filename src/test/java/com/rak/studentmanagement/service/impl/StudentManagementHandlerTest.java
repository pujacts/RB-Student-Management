package com.rak.studentmanagement.service.impl;

import com.rak.studentmanagement.entity.Student;
import com.rak.studentmanagement.model.SchoolDto;
import com.rak.studentmanagement.model.StudentDto;
import com.rak.studentmanagement.model.StudentRequestDto;
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
        StudentRequestDto request = new StudentRequestDto();
        request.setStudentName("John Doe");
        request.setMobileNumber("1234567890");
        SchoolDto schoolDetail = new SchoolDto();
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

        StudentDto response = studentManagementHandler.createStudent(request);

        assertEquals(1L, response.getStudentId());
        assertEquals("John Doe", response.getStudentName());
        assertEquals("1234567890", response.getMobileNumber());
        assertEquals("ABC School", response.getSchoolName());
        assertEquals("10", response.getGrade());
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

        StudentDto response = studentManagementHandler.deleteStudent(1L);

        assertEquals(1L, response.getStudentId());
        assertEquals("John Doe", response.getStudentName());
    }

    @Test
    void testUpdateStudent() {
        StudentRequestDto request = new StudentRequestDto();
        request.setStudentId(1L);
        request.setStudentName("Jane Doe");
        request.setMobileNumber("9876543210");
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setSchoolName("XYZ School");
        schoolDto.setGrade("12");
        request.setSchoolDetail(schoolDto);

        Student student = new Student();
        student.setStudentId(1L);
        student.setGrade("10");
        student.setName("John Doe");
        student.setMobileNumber("1234567890");
        student.setSchoolName("ABC School");

        given(studentRepository.findByStudentId(1L)).willReturn(Optional.of(student));
        given(studentRepository.save(any(Student.class))).willReturn(student);

        StudentDto response = studentManagementHandler.updateStudent(request);

        assertEquals(1L, response.getStudentId());
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

        List<StudentDto> response = studentManagementHandler.getAllStudents("ABC School", "10");

        assertEquals(1, response.size());
        assertEquals("ABC School", response.get(0).getSchoolName());
        assertEquals("10", response.get(0).getGrade());
    }

    @Test
    void testGetStudentByIdAndSchool() {
        Student student = new Student();
        student.setStudentId(1L);
        student.setName("John Doe");
        student.setSchoolName("ABC School");

        given(studentRepository.findByStudentIdAndSchoolName(1L, "ABC School")).willReturn(Optional.of(student));

        StudentDto studentResponse = studentManagementHandler.getStudentByIdAndSchool(1L, "ABC School");

        assertEquals("John Doe", studentResponse.getStudentName());
        assertEquals("ABC School", studentResponse.getSchoolName());
    }
}
