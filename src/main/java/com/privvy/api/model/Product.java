package com.privvy.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
public class Product {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    @Column(name = "img_path")
    private String pathToImg;
    @Getter
    @Setter
    private Double price;
    @Getter
    @Setter
    private Double discount;
    @Setter
    @Getter
    private Double rating;
    @Getter
    @Setter
    private Double totalRating;

    public Product() {

    }



    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", PathToImg='" + pathToImg + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
