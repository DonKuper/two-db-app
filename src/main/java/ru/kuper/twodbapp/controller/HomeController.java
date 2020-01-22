package ru.kuper.twodbapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kuper.twodbapp.domain.LangMongo;
import ru.kuper.twodbapp.domain.LangMySQL;
import ru.kuper.twodbapp.repo.LangMongoRepo;
import ru.kuper.twodbapp.repo.LangMySQLRepo;
import ru.kuper.twodbapp.service.EmailService;

@RestController
@RequestMapping(produces = "application/json")
public class HomeController {

    private LangMongoRepo langMongoRepo;
    private LangMySQLRepo langMySQLRepo;
    private EmailService emailService;

    @Autowired
    public HomeController(LangMongoRepo langMongoRepo, LangMySQLRepo langMySQLRepo, EmailService emailService) {
        this.langMongoRepo = langMongoRepo;
        this.langMySQLRepo = langMySQLRepo;
        this.emailService = emailService;
    }

    @GetMapping("nosql")
    public Iterable<LangMongo> getAllLangsByMongo(){
        return langMongoRepo.findAll();
    }

    @GetMapping({"/","sql"})
    public Iterable<LangMySQL> getAllLangsByMySQL(){
        return langMySQLRepo.findAll();
    }

    @GetMapping("/email/{subject}")
    public String sendEmail(@PathVariable("subject") String subject) {
        emailService.sendSimpleMessage(subject,"test from boot");
        return "send";
    }


}
