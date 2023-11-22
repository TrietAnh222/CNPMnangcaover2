package com.example.cnpmnangcaoriu.Models;

import com.google.gson.annotations.SerializedName;

public class UpdateuserRequest {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private Number sdt;
    @SerializedName("address")
    private String diachi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Number getSdt() {
        return sdt;
    }

    public void setSdt(Number sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
