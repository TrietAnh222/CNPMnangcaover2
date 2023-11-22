package com.example.cnpmnangcaoriu.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderRequest {
    @SerializedName("orderItems")
    private List<Orderproduct> orderItems;
    @SerializedName("paymentMethod")
    private String paymentMethod;
    @SerializedName("itemsPrice")
    private int itemsPrice;
    @SerializedName("shippingPrice")
    private int shippingPrice;
    @SerializedName("totalPrice")
    private int totalPrice;
    @SerializedName("fullName")
    private String fullname;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("user")
    private String iduser;
    @SerializedName("isPaid")
    private boolean isPaid;
    @SerializedName("paidAt")
    private String paidAt;

    @SerializedName("email")
    private String email;
    public static class Orderproduct{
        private String name;
        private int amount;
        private String image;
        private int price;
        private int discount;
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

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
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

    public void setOrderItems(List<Orderproduct> orderItems) {
        this.orderItems = orderItems;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getItemsPrice() {
        return itemsPrice;
    }

    public void setItemsPrice(int itemsPrice) {
        this.itemsPrice = itemsPrice;
    }

    public int getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(int shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
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

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

}
