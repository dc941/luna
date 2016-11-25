package luna.controller;

import luna.model.City;
import luna.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DC on 2016-11-14.
 */
@Controller
@RequestMapping("/City")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    private static final Logger log = LoggerFactory.getLogger(CityController.class);

    @RequestMapping(path = "/polled", method = RequestMethod.GET)
    public @ResponseBody List<City> getPolledCities() {
        return cityRepository.findByActive("Y");
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity addCity(@RequestParam String name, @RequestParam String countrycode){
        City lookup = cityRepository.findByNameAndCountryCode(name,countrycode);
        if(lookup == null){
            City city = new City(name, countrycode, "Y");
            cityRepository.save(city);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            if (lookup.getActive().equals("N")){
                lookup.setActive("Y");
                cityRepository.save(lookup);
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCity(@PathVariable long id){
        City lookup = cityRepository.findOne(id);
        log.debug(lookup.toString());
        if(lookup == null){
            log.debug("city not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            if (lookup.getActive().equals("Y")){
                lookup.setActive("N");
                cityRepository.save(lookup);
                log.debug("active city set to inactive");
                return new ResponseEntity(HttpStatus.OK);
            }
            log.debug("inactive city not changed");
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @RequestMapping(path = "getTest", method = RequestMethod.GET)
    public @ResponseBody City getTest() {

        City result = cityRepository.findOne(Long.valueOf(21));
        log.info("getTest-endpoint returns: " + result.toString());
        return result;
    }


}
