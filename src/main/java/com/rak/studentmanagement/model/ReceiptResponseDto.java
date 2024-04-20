package com.rak.studentmanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
@JsonRootName("ReceiptResponse")
public class ReceiptResponseDto {
    @JsonProperty("receiptDataList")
    private List<FeeReceiptDto> feeReceiptDtoList;
    @JsonProperty("purchaseDetailsResponse")
    private PurchaseDetailsResponse purchaseDetailsResponse;
    @JsonProperty("statusCode")
    private int statusCode;
    @JsonProperty("statusMessage")
    private String statusMessage;

    public List<FeeReceiptDto> getReceiptDataList() {
        return feeReceiptDtoList;
    }

    public void setReceiptDataList(List<FeeReceiptDto> feeReceiptDtoList) {
        this.feeReceiptDtoList = feeReceiptDtoList;
    }

    public PurchaseDetailsResponse getPurchaseDetailsResponse() {
        return purchaseDetailsResponse;
    }

    public void setPurchaseDetailsResponse(PurchaseDetailsResponse purchaseDetailsResponse) {
        this.purchaseDetailsResponse = purchaseDetailsResponse;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
