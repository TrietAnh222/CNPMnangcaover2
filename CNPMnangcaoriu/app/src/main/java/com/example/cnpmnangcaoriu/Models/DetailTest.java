package com.example.cnpmnangcaoriu.Models;

import com.google.gson.annotations.SerializedName;

public class DetailTest {
    @SerializedName("data")
    private ProductDetail detail;
    private boolean ischecked;
    private Number soluong;

    public boolean Ischecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public boolean isIschecked() {
        return ischecked;
    }

    public Number getSoluong() {
        return soluong;
    }

    public void setSoluong(Number soluong) {
        this.soluong = soluong;
    }

    public ProductDetail getDetail() {
        return detail;
    }

    public void setDetail(ProductDetail detail) {
        this.detail = detail;
    }

    public class ProductDetail {
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
    }
}
