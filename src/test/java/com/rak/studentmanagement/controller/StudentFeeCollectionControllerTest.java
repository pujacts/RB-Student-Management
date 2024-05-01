package com.rak.studentmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.rak.studentmanagement.model.PaymentRequestDto;
import com.rak.studentmanagement.model.ReceiptResponseDto;
import com.rak.studentmanagement.model.StudentDto;
import com.rak.studentmanagement.service.StudentService;
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
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class StudentFeeCollectionControllerTests {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentService;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    void testPerformFeePayment() throws Exception {
        PaymentRequestDto paymentRequest = new PaymentRequestDto();

        StudentDto studentDetails = new StudentDto();
        studentDetails.setStudentId(1l);

        paymentRequest.setStudentDto(studentDetails);

        ReceiptResponseDto receiptResponse = new ReceiptResponseDto();

        given(studentService.processFee(paymentRequest)).willReturn(receiptResponse);

        mockMvc.perform(post("/api/school/student/fee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paymentRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetStudentReceiptDetails() throws Exception {
        long studentId = 1L;
        ReceiptResponseDto receiptResponse = new ReceiptResponseDto();

        given(studentService.getStudentReceiptDetails(studentId)).willReturn(receiptResponse);

        mockMvc.perform(get("/api/school/{studentId}/receipt", studentId))
                .andExpect(status().isOk());
    }
}
