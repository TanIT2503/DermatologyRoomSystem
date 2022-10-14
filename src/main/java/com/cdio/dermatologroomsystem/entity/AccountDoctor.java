package com.cdio.dermatologroomsystem.entity;

public class AccountDoctor {
    private Doctor doctor;
    private Account account;

    public AccountDoctor() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
