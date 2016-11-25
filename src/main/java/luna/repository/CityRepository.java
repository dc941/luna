package luna.repository;

import luna.model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findByActive(String active);
    City findByNameAndCountryCode(String name, String Countrycode);
}