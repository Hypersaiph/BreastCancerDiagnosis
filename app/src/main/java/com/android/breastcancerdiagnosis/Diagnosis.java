package com.android.breastcancerdiagnosis;

/**
 * Created by gvs on 12/6/17.
 */

public class Diagnosis {
    private int id;
    private String date;
    private String patientID;
    private boolean malignant;

    public Diagnosis(int id, String date, String patientID, boolean malignant) {
        this.id = id;
        this.date = date;
        this.patientID = patientID;
        this.malignant = malignant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public boolean isMalignant() {
        return malignant;
    }

    public void setMalignant(boolean malignant) {
        this.malignant = malignant;
    }
}
