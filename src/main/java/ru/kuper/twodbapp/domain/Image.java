package ru.kuper.twodbapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String description;

    @Lob
    private Byte[] image;

    public Image() {
    }

    public Image(String description, Byte[] image) {
        this.description = description;
        this.image = image;
    }
}
