package com.rak.studentmanagement.service.impl;

import com.rak.studentmanagement.config.FeeCollectionProperties;
import com.rak.studentmanagement.exception.BusinessException;
import com.rak.studentmanagement.model.PaymentRequest;
import com.rak.studentmanagement.model.ReceiptResponse;
import com.rak.studentmanagement.service.FeeServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.rak.studentmanagement.constant.FeeClientConstants.*;
import static java.util.Collections.emptyList;

@Service
public class FeeServiceClientImpl implements FeeServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(FeeServiceClientImpl.class);
    private final RestTemplate restTemplate;
    private final FeeCollectionProperties feeCollectionProperties;

    private static final String SERVICE = "feeService";
    private static final String FALLBACK_METHOD = "fetchReceiptDetailsFallback";


    public FeeServiceClientImpl(RestTemplate restTemplate, FeeCollectionProperties feeCollectionProperties) {
        this.restTemplate = restTemplate;
        this.feeCollectionProperties = feeCollectionProperties;
    }

    @Override
/*    @Retry(name = SERVICE)
    @Bulkhead(name = SERVICE)
    @CircuitBreaker(name = SERVICE, fallbackMethod = FALLBACK_METHOD)*/
    public ReceiptResponse performFeePayment(final PaymentRequest paymentRequest) {
        logger.info("Perform fee payment of Student ID :: [{}] ", paymentRequest.getStudentDetails().getStudentId());
        try {
            ResponseEntity<ReceiptResponse> responseEntity = restTemplate.postForEntity(
                    feeCollectionProperties.getServices().get(HOST_URL) +
                            feeCollectionProperties.getServices().get(RECEIPT_BASE_URL) +
                            feeCollectionProperties.getServices().get(FEE_PAYMENT),
                    paymentRequest,
                    ReceiptResponse.class
            );
            return responseEntity.getBody();
        } catch (Exception ex) {
            logger.error("Error creating tuition fee: {}", ex.getMessage());
            throw new BusinessException(String.format("Failed to make tuition fee payment for Student ID [{}]", paymentRequest.getStudentDetails().getStudentId()));
        }
    }

    @Override
/*    @Retry(name = SERVICE)
    @Bulkhead(name = SERVICE)
    @CircuitBreaker(name = SERVICE, fallbackMethod = FALLBACK_METHOD)*/
    public ReceiptResponse fetchReceiptDetails(final Long studentId) {
        logger.info("Fetch receipt details of Student ID :: [{}] ", studentId);
        try {
            ResponseEntity<ReceiptResponse> responseEntity = restTemplate.getForEntity(
                    feeCollectionProperties.getServices().get(HOST_URL) +
                            feeCollectionProperties.getServices().get(RECEIPT_BASE_URL) +
                            feeCollectionProperties.getServices().get(RECEIPT_DETAILS) +
                            studentId,
                    ReceiptResponse.class
            );
            return responseEntity.getBody();
        } catch (Exception ex) {
            logger.error("Error fetching receipt details: {}", ex.getMessage());
            throw new BusinessException(String.format("Failed to fetch Receipt Details for Student ID [{}]", studentId));
        }
    }

    private ReceiptResponse fetchReceiptDetailsFallback(Throwable throwable) {
        ReceiptResponse receiptResponse = new ReceiptResponse();
        receiptResponse.setReceiptDataList(emptyList());
        receiptResponse.setStatusCode(SERVICE_UNAVAILABLE_CODE);
        receiptResponse.setStatusMessage(SERVICE_UNAVAILABLE);
        return receiptResponse;
    }
}
