package com.rak.studentmanagement.admin;

import com.rak.studentmanagement.model.StudentDto;
import com.rak.studentmanagement.model.StudentRequestDto;
import com.rak.studentmanagement.service.StudentManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTests {

    private static final String ADMIN_RESOURCE_ROOT = "/api/admin";
    private static final String RETRIEVE_STUDENT_BY_STUDENTID_SCHOOLNAME = "/student/{studentId}/{schoolName}";
    private static final String ALL_STUDENT_BY_SCHOOLNAME_GRADE = "/students/{schoolName}/{grade}";
    private static final String BASE_RESOURCE = "/student";
    private static final String DELETE_STUDENT_BY_STUDENT_ID = "/students/{studentId}";
    private static final String UPDATE_STUDENT_BY_STUDENT_ID = "/students/{studentId}";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentManagementService studentManagementService;

    @Test
    void testCreateStudent() throws Exception {

        given(studentManagementService.createStudent(any(StudentRequestDto.class))).willReturn(new StudentDto());

        mockMvc.perform(post(ADMIN_RESOURCE_ROOT + BASE_RESOURCE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testRemoveStudent() throws Exception {
        long studentId = 1L;

        given(studentManagementService.deleteStudent(anyLong())).willReturn(new StudentDto());

        mockMvc.perform(delete(ADMIN_RESOURCE_ROOT + DELETE_STUDENT_BY_STUDENT_ID, studentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateStudent() throws Exception {

        long studentId = 1L;
        given(studentManagementService.updateStudent(anyLong(), any(StudentRequestDto.class))).willReturn(new StudentDto());

        mockMvc.perform(put(ADMIN_RESOURCE_ROOT + UPDATE_STUDENT_BY_STUDENT_ID , studentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllStudents() throws Exception {
        String school = "ABC School";
        String grade = "10";
        given(studentManagementService.getAllStudents(school, grade)).willReturn(Arrays.asList(new StudentDto()));

        mockMvc.perform(get(ADMIN_RESOURCE_ROOT + ALL_STUDENT_BY_SCHOOLNAME_GRADE, school, grade))
                .andExpect(status().isOk());
    }

    @Test
    void testGetStudentByIdAndSchool() throws Exception {
        long studentId = 1L;
        String school = "ABC School";
        given(studentManagementService.getStudentByIdAndSchool(studentId, school)).willReturn(new StudentDto());

        mockMvc.perform(get(ADMIN_RESOURCE_ROOT + RETRIEVE_STUDENT_BY_STUDENTID_SCHOOLNAME, studentId, school))
                .andExpect(status().isOk());
    }

}
