package luna.service;

import com.google.gson.*;
import luna.model.*;
import luna.repository.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;


@Component
public class ParsingService {

    private static final Logger log = LoggerFactory.getLogger(ParsingService.class);

    private WeatherFileRepository weatherFileRepository;
    private CloudsRepository cloudsRepository;
    private CoordRepository coordRepository;
    private MainRepository mainRepository;
    private SysRepository sysRepository;
    private WeatherRepository weatherRepository;
    private WindRepository windRepository;

    @Autowired
    public ParsingService(WeatherFileRepository weatherFileRepository,
                          CloudsRepository cloudsRepository,
                          CoordRepository coordRepository,
                          MainRepository mainRepository,
                          SysRepository sysRepository,
                          WeatherRepository weatherRepository,
                          WindRepository windRepository){
        this.weatherFileRepository = weatherFileRepository;
        this.cloudsRepository = cloudsRepository;
        this.coordRepository = coordRepository;
        this.mainRepository = mainRepository;
        this.sysRepository = sysRepository;
        this.weatherRepository = weatherRepository;
        this.windRepository = windRepository;
    }

    public void persistFromString(String apiResponse, City city){
        //create parsing engine from api response string
        JsonElement responseParser = new JsonParser().parse(apiResponse);

        //parse api response string into generic object
        JsonObject  jobject = responseParser.getAsJsonObject();

        //create subobjects through parts of generic object
        JsonObject cloudsObject = jobject.getAsJsonObject("clouds");
        Clouds clouds = new Clouds(cloudsObject.get("all").getAsInt());
        cloudsRepository.save(clouds);

        JsonObject coordObject = jobject.getAsJsonObject("coord");
        Coord coord = new Coord(coordObject.get("lon").getAsDouble(),coordObject.get("lat").getAsDouble());
        coordRepository.save(coord);

        JsonObject mainObject = jobject.getAsJsonObject("main");
        Main main = new Main(mainObject.get("temp").getAsDouble(), mainObject.get("pressure").getAsDouble(), mainObject.get("humidity").getAsInt());
        mainRepository.save(main);

        JsonObject sysObject = jobject.getAsJsonObject("sys");
        Sys sys = new Sys(sysObject.get("country").getAsString(), sysObject.get("sunrise").getAsLong(), sysObject.get("sunset").getAsLong());
        sysRepository.save(sys);

        JsonArray weatherArray = jobject.getAsJsonArray("weather");
        JsonObject weatherObject = weatherArray.get(0).getAsJsonObject();
        Weather weather = new Weather(weatherObject.get("main").getAsString(), weatherObject.get("description").getAsString());
        weatherRepository.save(weather);

        JsonObject windObject = jobject.getAsJsonObject("wind");
        Wind wind = new Wind(windObject.get("speed").getAsDouble(), windObject.get("deg").getAsDouble());
        windRepository.save(wind);

        //create full WeatherFile with all generated objects and information from the string and persist it
        WeatherFile weatherFile = new WeatherFile(coord, weather, main, wind, clouds, jobject.get("dt").getAsLong(), sys, city);
        weatherFileRepository.save(weatherFile);
    }
}
