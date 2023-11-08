package com.example.cnpmnangcaoriu.Models;

import java.util.Date;
import java.util.List;
public class OrderProduct{
    public class Order {
        private List<OrderItem> orderItems;
        private ShippingAddress shippingAddress;
        private String paymentMethod;
        private double itemsPrice;
        private double shippingPrice;
        private double totalPrice;
        private User user;
        private boolean isPaid;
        private Date paidAt;
        private boolean isDelivered;
        private Date deliveredAt;

        public List<OrderItem> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
        }

        public ShippingAddress getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(ShippingAddress shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public double getItemsPrice() {
            return itemsPrice;
        }

        public void setItemsPrice(double itemsPrice) {
            this.itemsPrice = itemsPrice;
        }

        public double getShippingPrice() {
            return shippingPrice;
        }

        public void setShippingPrice(double shippingPrice) {
            this.shippingPrice = shippingPrice;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public boolean isPaid() {
            return isPaid;
        }

        public void setPaid(boolean paid) {
            isPaid = paid;
        }

        public Date getPaidAt() {
            return paidAt;
        }

        public void setPaidAt(Date paidAt) {
            this.paidAt = paidAt;
        }

        public boolean isDelivered() {
            return isDelivered;
        }

        public void setDelivered(boolean delivered) {
            isDelivered = delivered;
        }

        public Date getDeliveredAt() {
            return deliveredAt;
        }

        public void setDeliveredAt(Date deliveredAt) {
            this.deliveredAt = deliveredAt;
        }
    }

    public class OrderItem {
        private String name;
        private int amount;
        private String image;
        private double price;
        private Double discount;
        private ProductModel.Product product;

        // Getters và setters cho các trường

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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Double getDiscount() {
            return discount;
        }

        public void setDiscount(Double discount) {
            this.discount = discount;
        }

        public ProductModel.Product getProduct() {
            return product;
        }

        public void setProduct(ProductModel.Product product) {
            this.product = product;
        }
    }

    public class ShippingAddress {
        private String fullName;
        private String address;
        private String city;
        private long phone;
        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
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

        public long getPhone() {
            return phone;
        }

        public void setPhone(long phone) {
            this.phone = phone;
        }
    }
}
