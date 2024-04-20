package com.rak.studentmanagement.service.impl;

import com.rak.studentmanagement.entity.Student;
import com.rak.studentmanagement.exception.StudentNotFoundException;
import com.rak.studentmanagement.model.StudentDto;
import com.rak.studentmanagement.model.StudentRequestDto;
import com.rak.studentmanagement.repository.StudentRepository;
import com.rak.studentmanagement.service.StudentManagementService;
import com.rak.studentmanagement.util.StudentUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.rak.studentmanagement.util.StudentUtility.toDto;

@Service
public class StudentManagementHandler implements StudentManagementService {

    private static final Logger logger = LoggerFactory.getLogger(StudentManagementHandler.class);

    private final StudentRepository studentRepository;

    public StudentManagementHandler(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto createStudent(final StudentRequestDto studentDetailRequest) {
        Student student = new Student();
        student.setGrade(studentDetailRequest.getSchoolDetail().getGrade());
        student.setName(studentDetailRequest.getStudentName());
        student.setMobileNumber(studentDetailRequest.getMobileNumber());
        student.setSchoolName(studentDetailRequest.getSchoolDetail().getSchoolName());
        Student createdStudent = studentRepository.save(student);

        return toDto(createdStudent);
    }

    @Override
    public StudentDto deleteStudent(final Long studentId) {
        logger.info("Delete Student of Student ID :: [{}] ", studentId);

        final Student student = studentRepository.findByStudentId(studentId
        ).orElseThrow(() -> new StudentNotFoundException("Student not found for student ID " + studentId));
        studentRepository.deleteById(studentId);
        logger.info("Student deleted sucessfully :: [{}] ", studentId);

        return toDto(student);
    }

    @Override
    public StudentDto updateStudent(final Long studentId ,
                                    final StudentRequestDto studentDetailRequest) {
        logger.info("Update Student of Student ID :: [{}] ", studentId);
        final Student student = studentRepository.findByStudentId(studentId
        ).orElseThrow(() -> new StudentNotFoundException("Student not found for student ID " + studentId));


        student.setGrade(studentDetailRequest.getSchoolDetail().getGrade());
        student.setName(studentDetailRequest.getStudentName());
        student.setMobileNumber(studentDetailRequest.getMobileNumber());
        student.setSchoolName(studentDetailRequest.getSchoolDetail().getSchoolName());
        Student updateStudent = studentRepository.save(student);

        return toDto(updateStudent);
    }

    @Override
    public List<StudentDto> getAllStudents(final String schoolName, final String grade) {
        logger.info("Get All Student of School nam:: [{}] and Grade :: [{}] ", schoolName, grade);
        final List<Student> studentList = studentRepository.findBySchoolNameAndGrade(schoolName, grade);
        return studentList.stream()
                .map(StudentUtility::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentByIdAndSchool(final long studentId, final String schoolName) {
        logger.info("Get Student of Student ID :: [{}] and School :: [{}] ", studentId, schoolName);
        return studentRepository.findByStudentIdAndSchoolName(studentId, schoolName
        ).map(StudentUtility::toDto).orElseThrow(() -> new StudentNotFoundException("Student not found for student ID " + studentId));

    }
}
