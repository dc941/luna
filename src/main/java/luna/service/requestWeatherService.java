package luna.service;

import luna.model.WeatherFile;
import luna.repository.weatherFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by pwluft on 2016-10-23.
 */

@Component
public class requestWeatherService {

    private static final Logger log = LoggerFactory.getLogger(requestWeatherService.class);

    private weatherFileRepository weatherFileRepository;
    private RestTemplate restTemplate;

    @Autowired
    public requestWeatherService(weatherFileRepository weatherFileRepository,
                                 RestTemplate restTemplate){
        this.weatherFileRepository = weatherFileRepository;
        this.restTemplate = restTemplate;
    }

    public void test(){
        WeatherFile result = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=ThunderBay,ca&appid=8464a6eb7d04914c422e48c412eff921", WeatherFile.class);
        log.info(result.toString());
    }
}
