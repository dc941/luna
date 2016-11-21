package luna.controller;

import luna.model.City;
import luna.repository.CityRepository;
import luna.scheduler.SchedulerComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by DC on 2016-11-14.
 */
@Controller
@RequestMapping("/City")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    private static final Logger log = LoggerFactory.getLogger(CityController.class);

    /*
    @RequestMapping(path = "/polled", method = RequestMethod.GET)
    public ArrayList<City> getPolledCities() {
        //TODO
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCity(City city){
        //TODO
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCity(@PathVariable long id){
        //TODO
    }
    */

    @RequestMapping(path = "getTest", method = RequestMethod.GET)
    public @ResponseBody City getTest() {

        City result = cityRepository.findOne(Long.valueOf(21));
        log.info("getTest returns: " + result.toString());
        return result;
    }


}
