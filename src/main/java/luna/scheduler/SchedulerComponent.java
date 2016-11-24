package luna.scheduler;

import luna.model.City;
import luna.repository.CityRepository;
import luna.repository.WeatherFileRepository;
import luna.service.ParsingService;
import luna.service.RequestWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by pwluft on 2016-10-23.
 */

@Component
public class SchedulerComponent {

    private static final Logger log = LoggerFactory.getLogger(SchedulerComponent.class);


    private RequestWeatherService requestWeatherService;
    private ParsingService parsingService;
    private WeatherFileRepository weatherFileRepository;
    private CityRepository cityRepository;

    @Autowired
    public SchedulerComponent(RequestWeatherService requestWeatherService,
                              ParsingService parsingService,
                              WeatherFileRepository WeatherFileRepository,
                              CityRepository cityRepository){
        this.requestWeatherService = requestWeatherService;
        this.parsingService = parsingService;
        this.weatherFileRepository = WeatherFileRepository;
        this.cityRepository = cityRepository;
        log.info("scheduler instantiated.");
    }

    //@Scheduled(cron = "0 12 * * * *")
    @Scheduled(initialDelay = 10, fixedDelay = 10000000)
    public void getWeatherData(){

        //for each active city in the database
        for(City city : cityRepository.findByActive("Y")){

            //get current weather information from api
            String apiResponse = requestWeatherService.requestWeatherData(city);
            log.info("API response is: " + apiResponse + "for city: " + city);

            //parse that information and persist it into the database
            parsingService.persistFromString(apiResponse, city);
        }
    }

}
