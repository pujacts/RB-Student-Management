package com.rak.studentmanagement.util;

import com.rak.studentmanagement.entity.Student;
import com.rak.studentmanagement.model.StudentDto;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentUtility {
    public static StudentDto toDto(Student student) {
        Assert.notNull(student, "Student is null");
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setStudentName(student.getName());
        studentDto.setGrade(student.getGrade());
        studentDto.setMobileNumber(student.getMobileNumber());
        studentDto.setSchoolName(student.getSchoolName());
        return studentDto;
    }

    public static List<StudentDto> mapStudentToStudentResponse(List<Student> students) {
        return Optional.ofNullable(students)
                .orElse(Collections.emptyList())
                .stream()
                .map(student -> {
                    StudentDto studentDetail = new StudentDto();
                    studentDetail.setStudentId(student.getStudentId());
                    studentDetail.setStudentName(student.getName());
                    studentDetail.setGrade(student.getGrade());
                    studentDetail.setMobileNumber(student.getMobileNumber());
                    studentDetail.setSchoolName(student.getSchoolName());
                    return studentDetail;
                })
                .collect(Collectors.toList());
    }
}
