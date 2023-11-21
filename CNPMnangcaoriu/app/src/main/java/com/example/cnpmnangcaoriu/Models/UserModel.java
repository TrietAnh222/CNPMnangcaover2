package com.example.cnpmnangcaoriu.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserModel {
        @SerializedName("data")
        private User user;

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }
        public class User
        {
        @SerializedName("_id")
        private String id;
        @SerializedName("email")
        private String Email;
        @SerializedName("password")
        private String Password;
        @SerializedName("isAdmin")
        private boolean Isadmin;
        @SerializedName("createdAt")
        private String createdAt;
        @SerializedName("updatedAt")
        private String updatedAt;
        @SerializedName("__v")
        private Number v;
        @SerializedName("address")
        private String Address;
        @SerializedName("avatar")
        private String Avatar;
        @SerializedName("name")
        private String name;
        @SerializedName("phone")
        private Number phone;
        @SerializedName("city")
        private String city;

                public String getId() {
                        return id;
                }

                public void setId(String id) {
                        this.id = id;
                }

                public String getEmail() {
                        return Email;
                }

                public void setEmail(String email) {
                        Email = email;
                }

                public String getPassword() {
                        return Password;
                }

                public void setPassword(String password) {
                        Password = password;
                }

                public boolean isIsadmin() {
                        return Isadmin;
                }

                public void setIsadmin(boolean isadmin) {
                        Isadmin = isadmin;
                }

                public String getCreatedAt() {
                        return createdAt;
                }

                public void setCreatedAt(String createdAt) {
                        this.createdAt = createdAt;
                }

                public String getUpdatedAt() {
                        return updatedAt;
                }

                public void setUpdatedAt(String updatedAt) {
                        this.updatedAt = updatedAt;
                }

                public Number getV() {
                        return v;
                }

                public void setV(Number v) {
                        this.v = v;
                }

                public String getAddress() {
                        return Address;
                }

                public void setAddress(String address) {
                        Address = address;
                }

                public String getAvatar() {
                        return Avatar;
                }

                public void setAvatar(String avatar) {
                        Avatar = avatar;
                }

                public String getName() {
                        return name;
                }

                public void setName(String name) {
                        this.name = name;
                }

                public Number getPhone() {
                        return phone;
                }

                public void setPhone(Number phone) {
                        this.phone = phone;
                }

                public String getCity() {
                        return city;
                }

                public void setCity(String city) {
                        this.city = city;
                }
        }
}
