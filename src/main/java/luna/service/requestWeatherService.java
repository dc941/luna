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

    private buildURLService buildURLService;
    private weatherFileRepository weatherFileRepository;
    private RestTemplate restTemplate;

    @Autowired
    public requestWeatherService(buildURLService buildURLService,
                                 weatherFileRepository weatherFileRepository,
                                 RestTemplate restTemplate){
        this.buildURLService = buildURLService;
        this.weatherFileRepository = weatherFileRepository;
        this.restTemplate = restTemplate;
    }

    public WeatherFile requestWeatherData(String cityName, String countryCode){
        WeatherFile result = restTemplate.getForObject(buildURLService.buildRequestURL(cityName,countryCode), WeatherFile.class);
        log.info(result.toString());
        return result;
    }
}
