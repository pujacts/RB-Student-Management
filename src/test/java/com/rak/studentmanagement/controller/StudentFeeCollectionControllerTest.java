package com.rak.studentmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.rak.studentmanagement.model.PaymentRequest;
import com.rak.studentmanagement.model.ReceiptResponse;
import com.rak.studentmanagement.model.StudentDetail;
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
        PaymentRequest paymentRequest = new PaymentRequest();

        StudentDetail studentDetails = new StudentDetail();
        studentDetails.setStudentId(1l);

        paymentRequest.setStudentDetails(studentDetails);

        ReceiptResponse receiptResponse = new ReceiptResponse();

        given(studentService.performFeePayment(paymentRequest)).willReturn(receiptResponse);

        mockMvc.perform(post("/api/student/school/fee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paymentRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetStudentReceiptDetails() throws Exception {
        long studentId = 1L;
        ReceiptResponse receiptResponse = new ReceiptResponse();

        given(studentService.getStudentReceiptDetails(studentId)).willReturn(receiptResponse);

        mockMvc.perform(get("/api/student/receipt/detail/{studentId}", studentId))
                .andExpect(status().isOk());
    }
}
