package com.example.cnpmnangcaoriu.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductModel {
    @SerializedName("data")
    private List<Product> data;

    public ProductModel(List<Product> data) {
        this.data = data;
    }

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    public class Product {
        @SerializedName("_id")
        private String id;
    
        @SerializedName("name")
        private String name;
    
        @SerializedName("image")
        private String image;
    
        @SerializedName("type")
        private String type;
    
        @SerializedName("price")
        private Number price;
    
        @SerializedName("countInStock")
        private Number countInStock;
    
        @SerializedName("rating")
        private Number rating;
    
        @SerializedName("description")
        private String description;
    
        @SerializedName("discount")
        private Number discount;
    
        @SerializedName("createdAt")
        private String createdAt;
    
        @SerializedName("updatedAt")
        private String updatedAt;
    
        @SerializedName("__v")
        private Number v;
    
        @SerializedName("selled")
        private Number selled;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Number getPrice() {
            return price;
        }

        public void setPrice(Number price) {
            this.price = price;
        }

        public Number getCountInStock() {
            return countInStock;
        }

        public void setCountInStock(Number countInStock) {
            this.countInStock = countInStock;
        }

        public Number getRating() {
            return rating;
        }

        public void setRating(Number rating) {
            this.rating = rating;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Number getDiscount() {
            return discount;
        }

        public void setDiscount(Number discount) {
            this.discount = discount;
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

        public Number getSelled() {
            return selled;
        }

        public void setSelled(Number selled) {
            this.selled = selled;
        }
    }
}
