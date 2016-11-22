package luna.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import luna.model.WeatherFile;
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
    public String requestWeatherData(String cityName, String countryCode){

        String result = restTemplate.getForObject(BuildURLService.buildRequestURL(cityName,countryCode), String.class);
        log.info("Request to API for "+ cityName + ", " + countryCode + " returns:" + result);
        return result;
    }
}
