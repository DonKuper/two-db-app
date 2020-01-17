package ru.kuper.twodbapp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.kuper.twodbapp.domain.LangMongo;

@Repository
public interface LangMongoRepo extends MongoRepository<LangMongo, String> {

}
