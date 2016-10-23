package luna.scheduler;

import luna.service.requestWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by pwluft on 2016-10-23.
 */

@Component
public class scheduler {

    private static final Logger log = LoggerFactory.getLogger(scheduler.class);


    private requestWeatherService service;

    @Autowired
    public scheduler(requestWeatherService service){
        this.service = service;
        log.info("scheduler instantiated.");
    }

    @Scheduled(initialDelay = 100, fixedRate = 360000)
    public void getWeatherData(){
        service.test();
    }

}
