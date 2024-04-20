//package com.rak.studentmanagement.admin;
//
//import com.rak.studentmanagement.model.StudentDto;
//import com.rak.studentmanagement.model.StudentRequestDto;
//import com.rak.studentmanagement.service.StudentManagementService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//class AdminControllerTests {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    StudentManagementService studentManagementService;
//
//    @Test
//    void testCreateStudent() throws Exception {
//
//        given(studentManagementService.createStudent(any(StudentRequestDto.class))).willReturn(new StudentDto());
//
//        mockMvc.perform(post("api/admin/student")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{}"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testRemoveStudent() throws Exception {
//        long studentId = 1L;
//
//        given(studentManagementService.deleteStudent(anyLong())).willReturn(new StudentDto());
//
//        mockMvc.perform(delete("api/admin/student/{studentId}", studentId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{}"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testUpdateStudent() throws Exception {
//
//        given(studentManagementService.updateStudent(any(StudentRequestDto.class))).willReturn(new StudentDto());
//
//        mockMvc.perform(put("api/admin/student")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{}"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testGetAllStudents() throws Exception {
//        String school = "ABC School";
//        String grade = "10";
//        given(studentManagementService.getAllStudents(school, grade)).willReturn(Arrays.asList(new StudentDto()));
//
//        mockMvc.perform(get("api/admin/students/{school}/{grade}", school, grade))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testGetStudentByIdAndSchool() throws Exception {
//        long studentId = 1L;
//        String school = "ABC School";
//        given(studentManagementService.getStudentByIdAndSchool(studentId, school)).willReturn(new StudentDto());
//
//        mockMvc.perform(get("api/admin/student/{studentId}/{school}", studentId, school))
//                .andExpect(status().isOk());
//    }
//
//}
