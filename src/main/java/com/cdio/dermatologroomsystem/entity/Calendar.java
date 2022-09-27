package com.cdio.dermatologroomsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cal_id;
    private String cal_date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "hours_id", referencedColumnName = "hours_id")
    private Hours hours;
    private String cal_status;

    @ManyToOne(cascade = CascadeType.MERGE)
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

    public String getCal_date() {
        return cal_date;
    }

    public void setCal_date(String cal_date) {
        this.cal_date = cal_date;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public String getCal_status() {
        return cal_status;
    }

    public void setCal_status(String cal_status) {
        this.cal_status = cal_status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
