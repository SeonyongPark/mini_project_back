package com.ssafy.whereismyhome.model.dto;

public class AggregateDTO {
    private String dongCode;

    private String dealAmount;

    public String getDongCode() {
        return dongCode;
    }

    public void setDongCode(String dongCode) {
        this.dongCode = dongCode;
    }

    public String getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }

    @Override
    public String toString() {
        return "AggregateDTO{" +
                "dongCode='" + dongCode + '\'' +
                ", dealAmount='" + dealAmount + '\'' +
                '}';
    }
}
