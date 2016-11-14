package luna.controller;

import luna.model.WeatherFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by DC on 2016-11-14.
 */
@Controller
@RequestMapping("/api/weatherfile")
public class WeatherFileController {

    @RequestMapping(path = "/getByDate", method = RequestMethod.GET)
    public WeatherFile getByDate(@RequestParam Date date){
        //TODO
    }

    @RequestMapping(path = "/getBetween", method = RequestMethod.GET)
    public ArrayList<WeatherFile> getBetweenDates(@RequestParam Date date1, @RequestParam Date date2) {
        //TODO
    }
}
