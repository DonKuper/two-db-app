package ru.kuper.twodbapp.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "language")
public class LangMySQL {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String creater;
    private String feature;

    public LangMySQL() {
    }

    public LangMySQL(String name, String creater, String feature) {
        this.name = name;
        this.creater = creater;
        this.feature = feature;
    }

}
