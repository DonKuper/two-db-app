package ru.kuper.twodbapp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kuper.twodbapp.domain.Image;

@Repository
public interface ImageRepo extends CrudRepository<Image, Long> {

}
