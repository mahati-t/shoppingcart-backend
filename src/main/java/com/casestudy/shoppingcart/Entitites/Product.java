package com.casestudy.shoppingcart.Entitites;

import javax.persistence.*;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String name;
    private int price;
    private String details;
    private String category;
    private String subcategory  ;
    private String url;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subcategory;
    }

    public void setSubCategory(String subCategory) {
        this.subcategory = subCategory;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product() {
    }

    public Product(int productId, String name, int price, String details, String category, String subcategory, String url) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.details = details;
        this.category = category;
        this.subcategory = subcategory;
        this.url = url;
    }
}
