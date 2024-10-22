package com.tzxy.minsu.entity;

import javax.persistence.*;

@Entity
@Table(name = "homestay")
public class Homestay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long homestayId;

    private String title;
    private String description;
    private Double price;
    private String address;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    // Constructors
    public Homestay() {
    }

    public Homestay(Long homestayId, String title, String description, Double price, String address, String imageUrl, User owner) {
        this.homestayId = homestayId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.address = address;
        this.imageUrl = imageUrl;
        this.owner = owner;
    }

    // Getters and Setters
    @Column(name = "homestay_id")
    public Long getHomestayId() {
        return homestayId;
    }

    public void setHomestayId(Long homestayId) {
        this.homestayId = homestayId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}