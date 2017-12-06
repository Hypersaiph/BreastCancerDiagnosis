package com.android.breastcancerdiagnosis;

/**
 * Created by gvs on 12/5/17.
 */

public class Patient {
    private int id;
    private String hospitalID;
    private String lastDate;
    private Double precision;
    private boolean malignant;

    public Patient(int id, String hospitalID, String lastDate, Double precision, boolean malignant) {
        this.id = id;
        this.hospitalID = hospitalID;
        this.lastDate = lastDate;
        this.precision = precision;
        this.malignant = malignant;
    }

    public int getId() {
        return id;
    }

    public String getHospitalID() {
        return hospitalID;
    }

    public String getLastDate() {
        return lastDate;
    }

    public Double getPrecision() {
        return precision;
    }

    public boolean isMalignant() {
        return malignant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    public void setMalignant(boolean malignant) {
        this.malignant = malignant;
    }
}
