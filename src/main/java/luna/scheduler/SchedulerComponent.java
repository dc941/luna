package luna.scheduler;

import luna.repository.WeatherFileRepository;
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


    private RequestWeatherService service;
    private WeatherFileRepository WeatherFileRepository;

    @Autowired
    public SchedulerComponent(RequestWeatherService service,
                              WeatherFileRepository WeatherFileRepository){
        this.service = service;
        this.WeatherFileRepository = WeatherFileRepository;
        log.info("scheduler instantiated.");
    }

    @Scheduled(cron = "0 12 * * *")
    public void getWeatherData(){

        log.info(service.requestWeatherData("ThunderBay","ca").toString());
        //TODO: add for/each loop & service call for every polled city
        //TODO: get Strings from requestWeatherService
        //TODO: parse results and persist them
    }

}
