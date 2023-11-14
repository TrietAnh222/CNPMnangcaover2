package com.example.cnpmnangcaoriu.Models;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String passsword;
    @SerializedName( "confirmPassword")
    private String confirm;

    public RegisterRequest(String email, String passsword, String confirm) {
        this.email = email;
        this.passsword = passsword;
        this.confirm = confirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
