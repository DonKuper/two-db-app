package ru.kuper.twodbapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kuper.twodbapp.domain.LangMongo;

@RestController
@RequestMapping(produces = "application/json")
public class HomeController {

    @GetMapping
    public Iterable<LangMongo> getAllLangsByMongo(){

    }


    @GetMapping
    public Iterable<LangMongo> getAllLangsByMySQL(){

    }
}
