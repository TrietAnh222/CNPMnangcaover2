package com.example.cnpmnangcaoriu.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderRequest {
    @SerializedName("orderItems")
    private List<Orderproduct> orderItems;
    @SerializedName("paymentMethod")
    private String paymentMethod;
    @SerializedName("itemsPrice")
    private Number itemsPrice;
    @SerializedName("shippingPrice")
    private Number shippingPrice;
    @SerializedName("totalPrice")
    private Number totalPrice;
    @SerializedName("fullName")
    private String fullname;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("phone")
    private Number phone;
    @SerializedName("user")
    private String iduser;
    @SerializedName("isPaid")
    private boolean isPaid;
    @SerializedName("paidAt")
    private String paidAt;

    @SerializedName("email")
    private String email;
    public static class Orderproduct{
        @SerializedName("name")
        private String name;

        @SerializedName("amount")
        private Number amount;

        @SerializedName("image")
        private String image;

        @SerializedName("price")
        private Number price;

        @SerializedName("discount")
        private Number discount;

        @SerializedName("product")
        private String productid;

        //constructor
        public Orderproduct() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Number getAmount() {
            return amount;
        }

        public void setAmount(Number amount) {
            this.amount = amount;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Number getPrice() {
            return price;
        }

        public void setPrice(Number price) {
            this.price = price;
        }

        public Number getDiscount() {
            return discount;
        }

        public void setDiscount(Number discount) {
            this.discount = discount;
        }

        public String getProductid() {
            return productid;
        }

        public void setProductid(String productid) {
            this.productid = productid;
        }
    }

    public OrderRequest() {
    }

    public List<Orderproduct> getOrderItems() {
        return orderItems;
    }

    public Number getPhone() {
        return phone;
    }

    public void setPhone(Number phone) {
        this.phone = phone;
    }

    public void setOrderItems(List<Orderproduct> orderItems) {
        this.orderItems = orderItems;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Number getItemsPrice() {
        return itemsPrice;
    }

    public void setItemsPrice(Number itemsPrice) {
        this.itemsPrice = itemsPrice;
    }

    public Number getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Number shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public Number getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Number totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(String paidAt) {
        this.paidAt = paidAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
