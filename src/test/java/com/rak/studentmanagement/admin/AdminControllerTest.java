package com.rak.studentmanagement.admin;

import com.rak.studentmanagement.model.StudentDetailRequest;
import com.rak.studentmanagement.model.StudentResponse;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentManagementService studentManagementService;

    @Test
    void testCreateStudent() throws Exception {
        StudentResponse studentResponse = new StudentResponse();

        given(studentManagementService.createStudent(any(StudentDetailRequest.class))).willReturn(studentResponse);

        mockMvc.perform(post("/admin/student/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testRemoveStudent() throws Exception {
        long studentId = 1L;
        StudentResponse studentResponse = new StudentResponse();

        given(studentManagementService.deleteStudent(anyLong())).willReturn(studentResponse);

        mockMvc.perform(delete("/admin/student/delete/{studentId}", studentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateStudent() throws Exception {
        StudentResponse studentResponse = new StudentResponse();

        given(studentManagementService.updateStudent(any(StudentDetailRequest.class))).willReturn(studentResponse);

        mockMvc.perform(put("/admin/student/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllStudents() throws Exception {
        String school = "ABC School";
        String grade = "10";
        StudentResponse studentResponse = new StudentResponse();

        given(studentManagementService.getAllStudents(school, grade)).willReturn(studentResponse);

        mockMvc.perform(get("/admin/student/all/{school}/{grade}", school, grade))
                .andExpect(status().isOk());
    }

    @Test
    void testGetStudentByIdAndSchool() throws Exception {
        long studentId = 1L;
        String school = "ABC School";
        StudentResponse studentResponse = new StudentResponse();

        given(studentManagementService.getStudentByIdAndSchool(studentId, school)).willReturn(studentResponse);

        mockMvc.perform(get("/admin/student/{studentId}/{school}", studentId, school))
                .andExpect(status().isOk());
    }

}
