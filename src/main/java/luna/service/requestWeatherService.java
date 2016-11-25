package luna.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import luna.model.City;
import luna.repository.WeatherFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class RequestWeatherService {

    private static final Logger log = LoggerFactory.getLogger(RequestWeatherService.class);

    private BuildURLService BuildURLService;
    private WeatherFileRepository WeatherFileRepository;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    @Autowired
    public RequestWeatherService(BuildURLService BuildURLService,
                                 WeatherFileRepository WeatherFileRepository,
                                 ObjectMapper objectMapper){
        this.BuildURLService = BuildURLService;
        this.WeatherFileRepository = WeatherFileRepository;
        this.restTemplate = new RestTemplate();
    }

    //Requests information from OpenWeatherAPI and returns answer as String
    public String requestWeatherData(City city){

        String result = restTemplate.getForObject(BuildURLService.buildRequestURL(city), String.class);
        log.info("Request to API for "+ city.getName() + ", " + city.getCountryCode() + " returns:" + result);
        return result;
    }
}
