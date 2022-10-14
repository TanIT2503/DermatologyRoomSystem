package com.cdio.dermatologroomsystem.entity;

public class AccountPatient {
    private Patient patient;
    private Account account;

    public AccountPatient() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
