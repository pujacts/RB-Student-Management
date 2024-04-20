package com.rak.studentmanagement.service.impl;

import com.rak.fee.service.FeeServiceClient;
import com.rak.fee.service.model.PaymentRequest;
import com.rak.fee.service.model.ReceiptResponse;
import com.rak.studentmanagement.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final FeeServiceClient feeServiceClient;

    public StudentServiceImpl(FeeServiceClient feeServiceClient) {
        this.feeServiceClient = feeServiceClient;
    }
    @Override
    public ReceiptResponse performFeePayment(final PaymentRequest paymentRequest) {
        logger.info("Perform Fee Payment for Student ID :: [{}] ", paymentRequest.getStudentDetails().getStudentId());
        return feeServiceClient.performFeePayment(paymentRequest);
    }

    @Override
    public ReceiptResponse getStudentReceiptDetails(final Long studentId) {
        logger.info("Get Student Receipt Details for Student ID :: [{}] ", studentId);
        return feeServiceClient.fetchReceiptDetails(studentId);
    }
}
