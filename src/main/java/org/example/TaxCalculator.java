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

    private void initSlab(){

        // 1--> old regime
        // 2--> new regime

        slab = new HashMap<>();

        slab.put(1,new HashMap<>());
        slab.put(2,new HashMap<>());

        // < 60
        ArrayList<ArrayList<Integer>> less60 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> a60l80 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> a80 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();



        less60.add(new ArrayList<>(Arrays.asList(250000,0)));
        less60.add(new ArrayList<>(Arrays.asList(250000,5)));
        less60.add(new ArrayList<>(Arrays.asList(500000,20)));
        less60.add(new ArrayList<>(Arrays.asList(-1,30)));
        slab.get(1).put(1,less60);

        a60l80.add(new ArrayList<>(Arrays.asList(300000,0)));
        a60l80.add(new ArrayList<>(Arrays.asList(200000,5)));
        a60l80.add(new ArrayList<>(Arrays.asList(500000,20)));
        a60l80.add(new ArrayList<>(Arrays.asList(-1,30)));
        slab.get(1).put(2,a60l80);

        a80.add(new ArrayList<>(Arrays.asList(500000,0)));
        a80.add(new ArrayList<>(Arrays.asList(500000,20)));
        a80.add(new ArrayList<>(Arrays.asList(-1,30)));
        slab.get(1).put(3,a80);

        all.add(new ArrayList<>(Arrays.asList(250000,0)));
        all.add(new ArrayList<>(Arrays.asList(250000,5)));
        all.add(new ArrayList<>(Arrays.asList(250000,10)));
        all.add(new ArrayList<>(Arrays.asList(250000,15)));
        all.add(new ArrayList<>(Arrays.asList(250000,20)));
        all.add(new ArrayList<>(Arrays.asList(250000,25)));
        all.add(new ArrayList<>(Arrays.asList(-1,30)));
        slab.get(2).put(0,all);

    }
}