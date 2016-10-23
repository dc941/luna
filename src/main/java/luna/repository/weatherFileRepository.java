package luna.repository;

import luna.model.WeatherFile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by pwluft on 2016-10-23.
 */
public interface weatherFileRepository extends CrudRepository<WeatherFile, Long> {

    //TODO: check if this works that way and improve generated queries for next feature
    List<WeatherFile> findBySysCountry(String SysCountry);
}