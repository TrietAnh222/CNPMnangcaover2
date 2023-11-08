package com.example.cnpmnangcaoriu.Models;

public class User{

        private String Name;
        private String Email;
        private String Password;
        private boolean Isadmin;
        private Number phone;
        private String Address;
        private String Avatar;
        private String City;

        public User(String name, String email, String password, boolean isadmin, Number phone, String address, String avatar, String city) {
            Name = name;
            Email = email;
            Password = password;
            Isadmin = isadmin;
            this.phone = phone;
            Address = address;
            Avatar = avatar;
            City = city;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
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

        public Number getPhone() {
            return phone;
        }

        public void setPhone(Number phone) {
            this.phone = phone;
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

        public String getCity() {
            return City;
        }

        public void setCity(String city) {
            City = city;
        }
}
