package com.example.cnpmnangcaoriu.Models;

import com.google.gson.annotations.SerializedName;

public class LogInResponse {
    @SerializedName("access_token")
    private String accesstoken;
    @SerializedName( "refresh_token")
    private String refreshtoken;

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getRefreshtoken() {
        return refreshtoken;
    }

    public void setRefreshtoken(String refreshtoken) {
        this.refreshtoken = refreshtoken;
    }
}
