package luna.repository;

import luna.model.WeatherFile;
import org.springframework.data.repository.CrudRepository;

public interface WeatherFileRepository extends CrudRepository<WeatherFile, Long> {

}