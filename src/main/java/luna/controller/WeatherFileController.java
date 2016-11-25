package luna.controller;

import luna.model.WeatherFile;
import luna.repository.WeatherFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by DC on 2016-11-14.
 */
@Controller
@RequestMapping("/Weatherfile")
public class WeatherFileController {

    @Autowired
    private WeatherFileRepository weatherfileRepository;

    private static final Logger log = LoggerFactory.getLogger(WeatherFileController.class);

    @RequestMapping(path = "/getByDate", method = RequestMethod.GET)
    public @ResponseBody List<WeatherFile> getByDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        log.info("requesting weatherfiles for date: " + date.toString());
        return weatherfileRepository.findByDateCreated(date);
    }

    @RequestMapping(path = "/getBetween", method = RequestMethod.GET)
    public @ResponseBody List<WeatherFile> getBetweenDates(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date1, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date2) {
        log.info("requesting weatherfiles between date1: " + date1.toString() + " and date2: " + date2.toString());
        return weatherfileRepository.findByDateCreatedBetween(date1,date2);
    }

    @RequestMapping(path = "getTest", method = RequestMethod.GET)
    public @ResponseBody WeatherFile getTest() {
        WeatherFile result = weatherfileRepository.findOne(Long.valueOf(1));
        log.info("getTest-endpoint returns: " + result.toString());
        return result;
    }
}


