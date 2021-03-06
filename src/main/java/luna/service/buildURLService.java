package luna.service;

import luna.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by DC on 2016-10-26.
 */

@Component
public class BuildURLService {

    private static final Logger log = LoggerFactory.getLogger(BuildURLService.class);

    @Value("${luna.openweatheruri}")
    private String baseUri;

    @Value("${luna.apikey}")
    private String apiKey;

    //TODO: implement saved cities, then clean up this method
    public String buildRequestURL(City city){

        String result;

        if(StringUtils.isEmpty(StringUtils.trimAllWhitespace(city.getCountryCode()))){
            result = baseUri + "?q=" + city.getName() + "&appid=" + apiKey;
        } else {
            result = baseUri + "?q=" + city.getName() + "," + city.getCountryCode() + "&appid=" + apiKey;
        }

        log.debug("returning URL " + result);
        return result;
    }
}
