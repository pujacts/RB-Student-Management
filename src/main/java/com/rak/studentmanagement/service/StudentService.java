package com.rak.studentmanagement.service;

import com.rak.fee.service.model.PaymentRequest;
import com.rak.fee.service.model.ReceiptResponse;

public interface StudentService {
    ReceiptResponse performFeePayment(final PaymentRequest paymentRequest);
    ReceiptResponse getStudentReceiptDetails(final Long studentId);
}
