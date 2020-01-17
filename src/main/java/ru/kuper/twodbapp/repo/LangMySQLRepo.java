package ru.kuper.twodbapp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kuper.twodbapp.domain.LangMySQL;

@Repository
public interface LangMySQLRepo extends CrudRepository<LangMySQL, Long> {


}
