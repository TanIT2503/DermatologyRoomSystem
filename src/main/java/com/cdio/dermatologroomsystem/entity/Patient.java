package com.cdio.dermatologroomsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pa_id;
    private String pa_name;
    private String pa_birthday;
    private boolean pa_gender;
    private String pa_address;
    private String pa_phone;
    private String pa_id_card;
    private String pa_email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    @Nullable
    private Account account;

//    @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER)
//    @JsonBackReference
//    private List<Calendar> calendarList = new ArrayList<>();

    public Patient() {
    }

    public int getPa_id() {
        return pa_id;
    }

    public void setPa_id(int pa_id) {
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

    public String getPa_phone() {
        return pa_phone;
    }

    public void setPa_phone(String pa_phone) {
        this.pa_phone = pa_phone;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

//    public List<Calendar> getCalendarList() {
//        return calendarList;
//    }
//
//    public void setCalendarList(List<Calendar> calendarList) {
//        this.calendarList = calendarList;
//    }
}
