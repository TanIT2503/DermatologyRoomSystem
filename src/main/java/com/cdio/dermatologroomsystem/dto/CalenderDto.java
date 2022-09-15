package com.cdio.dermatologroomsystem.dto;

import com.cdio.dermatologroomsystem.entity.Patient;


public class CalenderDto {
    private int cal_id;
    private String cal_time;
    private Patient patient;

    public CalenderDto() {
    }

    public int getCal_id() {
        return cal_id;
    }

    public void setCal_id(int cal_id) {
        this.cal_id = cal_id;
    }

    public String getCal_time() {
        return cal_time;
    }

    public void setCal_time(String cal_time) {
        this.cal_time = cal_time;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
