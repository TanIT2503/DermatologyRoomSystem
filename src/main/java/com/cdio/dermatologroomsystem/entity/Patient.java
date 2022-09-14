package com.cdio.dermatologroomsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String pa_id;
    private String pa_name;
    private String pa_birthday;
    private boolean pa_gender;
    private String pa_address;
    private String pa_id_card;
    private String pa_email;
    private String username;

    @OneToMany(mappedBy = "patient")
    @JsonBackReference
    private List<Calendar> calendarList = new ArrayList<>();

    public Patient() {
    }

    public String getPa_id() {
        return pa_id;
    }

    public void setPa_id(String pa_id) {
        this.pa_id = pa_id;
    }

    public String getPa_name() {
        return pa_name;
    }

    public void setPa_name(String pa_name) {
        this.pa_name = pa_name;
    }

    public String getPa_birthday() {
        return pa_birthday;
    }

    public void setPa_birthday(String pa_birthday) {
        this.pa_birthday = pa_birthday;
    }

    public boolean isPa_gender() {
        return pa_gender;
    }

    public void setPa_gender(boolean pa_gender) {
        this.pa_gender = pa_gender;
    }

    public String getPa_address() {
        return pa_address;
    }

    public void setPa_address(String pa_address) {
        this.pa_address = pa_address;
    }

    public String getPa_id_card() {
        return pa_id_card;
    }

    public void setPa_id_card(String pa_id_card) {
        this.pa_id_card = pa_id_card;
    }

    public String getPa_email() {
        return pa_email;
    }

    public void setPa_email(String pa_email) {
        this.pa_email = pa_email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
