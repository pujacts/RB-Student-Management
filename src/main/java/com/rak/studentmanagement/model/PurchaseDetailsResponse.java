package com.rak.studentmanagement.model;

public class PurchaseDetailsResponse {
    private double tuitionFee;
    private int paidForCount;
    private String grade;

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public int getPaidForCount() {
        return paidForCount;
    }

    public void setPaidForCount(int paidForCount) {
        this.paidForCount = paidForCount;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
