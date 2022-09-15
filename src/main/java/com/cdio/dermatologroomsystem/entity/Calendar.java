package com.cdio.dermatologroomsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cal_id;
    private String cal_time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pa_id", referencedColumnName = "pa_id")
    private Patient patient;

    public Calendar() {
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
