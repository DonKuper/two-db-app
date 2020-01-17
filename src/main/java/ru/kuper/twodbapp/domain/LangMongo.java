package ru.kuper.twodbapp.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "language") //Название БД
@Data
public class LangMongo {

    @Id
    private String id;

    private String name;
    private String creater;
    private String feature;

    public LangMongo() {
    }

    public LangMongo(String name, String creater, String feature) {
        this.name = name;
        this.creater = creater;
        this.feature = feature;
    }
}
