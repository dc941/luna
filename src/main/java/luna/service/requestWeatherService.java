package luna.service;

import luna.repository.weatherFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pwluft on 2016-10-23.
 */

@Component
public class requestWeatherService {

    private static final Logger log = LoggerFactory.getLogger(requestWeatherService.class);

    private weatherFileRepository weatherFileRepository;

    @Autowired
    public requestWeatherService(weatherFileRepository weatherFileRepository){
        this.weatherFileRepository = weatherFileRepository;
    }

    public void test(){
        weatherFileRepository.save(result);
    }
}
