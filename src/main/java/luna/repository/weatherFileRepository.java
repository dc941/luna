package luna.repository;

import luna.model.WeatherFile;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public interface WeatherFileRepository extends CrudRepository<WeatherFile, Long> {

    List<WeatherFile> findByDateCreated(@Temporal(TemporalType.DATE)Date date_created);

    List<WeatherFile> findByDateCreatedBetween(@Temporal(TemporalType.DATE)Date date_created1, Date date_created2);
}