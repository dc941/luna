package luna.controller;

import luna.model.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by DC on 2016-11-14.
 */
@Controller
@RequestMapping("/city")
public class CityController {

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

}
