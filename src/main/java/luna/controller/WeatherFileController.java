package luna.controller;

import luna.model.WeatherFile;
import luna.repository.WeatherFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by DC on 2016-11-14.
 */
@Controller
@RequestMapping("/weatherfile")
public class WeatherFileController {

    @Autowired
    private WeatherFileRepository WeatherfileRepository;

    private static final Logger log = LoggerFactory.getLogger(WeatherFileController.class);

    /*
    @RequestMapping(path = "/getByDate", method = RequestMethod.GET)
    public WeatherFile getByDate(@RequestParam Date date){
        //TODO
    }

    @RequestMapping(path = "/getBetween", method = RequestMethod.GET)
    public ArrayList<WeatherFile> getBetweenDates(@RequestParam Date date1, @RequestParam Date date2) {
        //TODO
    }

    @RequestMapping(path = "/getTest", method = RequestMethod.GET)
    public WeatherFile getTest(){
        //TODO
    }
    */

    @RequestMapping(path = "getTest", method = RequestMethod.GET)
    public @ResponseBody WeatherFile getTest() {
        WeatherFile result = WeatherfileRepository.findOne(Long.valueOf(1));
        log.info("getTest-endpoint returns: " + result.toString());
        return result;
    }
}


