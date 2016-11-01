package luna.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class WeatherFile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Coord Coord;

    @OneToOne
    private Weather Weather;

    @OneToOne
    private Main Main;

    @OneToOne
    private Wind Wind;

    @OneToOne
    private Clouds Clouds;

    @OneToOne
    private Sys Sys;

    //time of calculation in unix time
    private Long dt;

    public WeatherFile() {
    }

    public WeatherFile(long id, luna.model.Coord coord, luna.model.Weather weather,
                       luna.model.Main main, Wind wind, luna.model.Clouds clouds,
                       Long dt, luna.model.Sys sys) {
        this.id = id;
        this.Coord = coord;
        this.Weather = weather;
        this.Main = main;
        this.Wind = wind;
        this.Clouds = clouds;
        this.dt = dt;
        this.Sys = sys;
    }

    public Long getId() {
        return id;
    }

    public Coord getCoord() {
        return Coord;
    }

    public void setCoord(Coord Coord) {
        this.Coord = Coord;
    }

    public Weather getWeather() {
        return Weather;
    }

    public void setWeather(Weather Weather) {
        this.Weather = Weather;
    }

    public Main getMain() {
        return Main;
    }

    public void setMain(Main Main) {
        this.Main = Main;
    }

    public Wind getWind() {
        return Wind;
    }

    public void setWind(Wind wind) {
        this.Wind = wind;
    }

    public Clouds getClouds() {
        return Clouds;
    }

    public void setClouds(Clouds Clouds) {
        this.Clouds = Clouds;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return Sys;
    }

    public void setSys(Sys Sys) {
        this.Sys = Sys;
    }

    @Override
    public String toString() {
        return "WeatherFile{" +
                "id=" + id +
                ", Coord=" + Coord +
                ", Weather=" + Weather +
                ", Main=" + Main +
                ", Wind=" + Wind +
                ", Clouds=" + Clouds +
                ", dt=" + dt +
                ", Sys=" + Sys +
                '}';
    }
}
