package by.itclass._02_spring_jpa.repositories;

import by.itclass._02_spring_jpa.entities.Airplane;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Integer> {
    //find, get, query, delete, update
    //By            - whwre
    //Model, Places - condition
    Airplane findByModel(String model);
    Airplane findByModelAndPlaces(String model, int places);
    Airplane findByModelLike(String model);
    List<Airplane> findByIdBetween(int from, int to);
}
