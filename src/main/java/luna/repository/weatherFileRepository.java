package luna.repository;

import luna.model.WeatherFile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherFileRepository extends CrudRepository<WeatherFile, Long> {

}