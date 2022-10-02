package com.cdio.dermatologroomsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cal_id;
    private String cal_date;

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "hours_id", referencedColumnName = "hours_id")
//    private Hours hours;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cal_status_id", referencedColumnName = "cal_status_id")
    private CalendarStatus cal_status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pa_id", referencedColumnName = "pa_id")
    private Patient patient;

//    @OneToMany(mappedBy = "cal_id",fetch = FetchType.EAGER)
//    @JsonBackReference
//    private List<DoctorCalendar> doctorCalendars = new ArrayList<>();

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

    public CalendarStatus getCal_status() {
        return cal_status;
    }

    public void setCal_status(CalendarStatus cal_status) {
        this.cal_status = cal_status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }



    //    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }
}
