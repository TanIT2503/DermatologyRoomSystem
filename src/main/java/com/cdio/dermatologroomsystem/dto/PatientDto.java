package com.cdio.dermatologroomsystem.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PatientDto {
    private int pa_id;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "[a-zA-Z\\s]", message = "Tên chứa kí tự khác")
    private String pa_name;
    private String pa_birthday;
    private boolean pa_gender;
    @NotBlank(message = "Không được để trống")
    private String pa_address;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(0)9([0|1])[0-9]{7}$", message = "SĐT chưa đúng định dạng")
    private String pa_phone;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[0-9]{10,12}$", message = "CMND chưa đúng định dạng")
    private String pa_id_card;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "(\\W|^)[\\w.+\\-]*@gmail\\.com(\\W|$)", message = "Email chưa đúng định dạng")
    private String pa_email;
    private String username;

    public PatientDto() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
