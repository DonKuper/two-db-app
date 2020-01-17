package ru.kuper.twodbapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.kuper.twodbapp.domain.LangMongo;
import ru.kuper.twodbapp.domain.LangMySQL;
import ru.kuper.twodbapp.repo.LangMongoRepo;
import ru.kuper.twodbapp.repo.LangMySQLRepo;

@SpringBootApplication
public class TwoDbAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwoDbAppApplication.class, args);
    }


    @Bean
    public CommandLineRunner preload(LangMySQLRepo mySQLRepo, LangMongoRepo mongoRepo) {
        return args -> {
            mySQLRepo.save(new LangMySQL("java", "Gosling","imperative"));
            mySQLRepo.save(new LangMySQL("elexir", "valim","actor model"));
            mySQLRepo.save(new LangMySQL("scala", "odersky","functional"));
            mySQLRepo.save(new LangMySQL("clojure", "hitch","lisp"));

            mongoRepo.save(new LangMongo("java", "Gosling","imperative"));
            mongoRepo.save(new LangMongo("elexir", "valim","actor model"));
            mongoRepo.save(new LangMongo("scala", "odersky","functional"));
            mongoRepo.save(new LangMongo("clojure", "hitch","lisp"));

        };
    }

}
