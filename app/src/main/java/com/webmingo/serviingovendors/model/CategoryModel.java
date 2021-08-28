package com.webmingo.serviingovendors.model;

public class CategoryModel {


    public String id;


    public String name;
    public String icon;
    public String slug;
    public String reviewsHeading;
    public String reviewsTitle;
    public String faqTitle;
    public String shortDescription;
    public String aboutCategory;
    public Integer status;
    public String metaTitle;
    public String metaKeywords;
    public String metaDescription;
    public Integer avgRating;
    public String bannerTitle;
    public String bannerDescription;

   /* public CategoryModel() {
    }*/

    public CategoryModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryModel(String id, String name, String icon, String slug, String reviewsHeading, String reviewsTitle, String faqTitle, String shortDescription, String aboutCategory, Integer status, String metaTitle, String metaKeywords, String metaDescription, Integer avgRating, String bannerTitle, String bannerDescription) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.slug = slug;
        this.reviewsHeading = reviewsHeading;
        this.reviewsTitle = reviewsTitle;
        this.faqTitle = faqTitle;
        this.shortDescription = shortDescription;
        this.aboutCategory = aboutCategory;
        this.status = status;
        this.metaTitle = metaTitle;
        this.metaKeywords = metaKeywords;
        this.metaDescription = metaDescription;
        this.avgRating = avgRating;
        this.bannerTitle = bannerTitle;
        this.bannerDescription = bannerDescription;
    }
}
