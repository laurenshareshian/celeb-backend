package net.celebapp.matchmaker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DummyMatchesRepository extends CrudRepository<DummyMatchesEntity, Long> {

    List<DummyMatchesEntity> findAllByFirstName(@Param("first_name") String firstName);

    DummyMatchesEntity deleteById(Integer id);
}