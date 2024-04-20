package com.rak.studentmanagement.service;

import com.rak.studentmanagement.model.PaymentRequest;
import com.rak.studentmanagement.model.ReceiptResponse;

public interface FeeServiceClient {
    ReceiptResponse performFeePayment(final PaymentRequest paymentRequest);
    ReceiptResponse fetchReceiptDetails(final Long studentId);
}
