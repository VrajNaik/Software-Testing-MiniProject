package org.example;

import java.util.*;

public class TaxCalculator {
    private HashMap<Integer,HashMap<Integer,ArrayList<ArrayList<Integer>>>> slab;

    private Long type;

    private Long regimeId;

    private Scanner scanner;

    private Long ageGroupId;

    private Double deductedAmount;

    private Double taxableAmount;

    private Double taxAmount;

    private Double surCharge;

    private Double netTax;

    private Double healthAndEduCess;

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getRegimeId() {
        return regimeId;
    }

    public void setRegimeId(Long regimeId) {
        this.regimeId = regimeId;
    }

    public Long getAgeGroupId() {
        return ageGroupId;
    }

    public void setAgeGroupId(Long ageGroupId) {
        this.ageGroupId = ageGroupId;
    }

    public Double getDeductedAmount() {
        return deductedAmount;
    }

    public void setDeductedAmount(Double deductedAmount) {
        this.deductedAmount = deductedAmount;
    }

    public Double getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(Double taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getSurCharge() {
        return surCharge;
    }

    public void setSurCharge(Double surCharge) {
        this.surCharge = surCharge;
    }

    public Double getNetTax() {
        return netTax;
    }

    public void setNetTax(Double netTax) {
        this.netTax = netTax;
    }

    public Double getHealthAndEduCess() {
        return healthAndEduCess;
    }

    public void setHealthAndEduCess(Double healthAndEduCess) {
        this.healthAndEduCess = healthAndEduCess;
    }
}