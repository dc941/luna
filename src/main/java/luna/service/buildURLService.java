package luna.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by DC on 2016-10-26.
 */

@Component
public class buildURLService {

    private static final Logger log = LoggerFactory.getLogger(buildURLService.class);

    @Value("${luna.openweatheruri}")
    private String baseUri;

    @Value("${luna.apikey}")
    private String apiKey;

    //TODO: implement saved cities, then clean up this method
    public String buildRequestURL(String cityName, String countryCode){
        String result = baseUri + "?q=" + cityName + "," + countryCode + "&appid=" + apiKey;
        log.debug("returning URL " + result);
        return result;
    }
}
