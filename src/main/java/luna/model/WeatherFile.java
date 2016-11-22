package luna.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
@Table(name = "WEATHERFILE")
public class WeatherFile {

    @Id
    @GeneratedValue(generator="WeatherfileSeq")
    @SequenceGenerator(name="WeatherfileSeq",sequenceName="WEATHERFILE_SEQ", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn (name = "COORD_ID")
    private Coord Coord;

    @OneToOne
    @JoinColumn (name = "WEATHER_ID")
    private Weather Weather;

    @OneToOne
    @JoinColumn (name = "MAIN_ID")
    private Main Main;

    @OneToOne
    @JoinColumn (name = "WIND_ID")
    private Wind Wind;

    @OneToOne
    @JoinColumn (name = "CLOUDS_ID")
    private Clouds Clouds;

    @OneToOne
    @JoinColumn (name = "SYS_ID")
    private Sys Sys;

    //time of calculation in unix time
    @Column(name = "DT")
    private Long dt;

    @OneToOne
    @JoinColumn (name = "CITY_ID")
    private City City;

    public WeatherFile() {
    }

    public WeatherFile(long id, luna.model.Coord coord, luna.model.Weather weather,
                       luna.model.Main main, Wind wind, luna.model.Clouds clouds,
                       Long dt, luna.model.Sys sys, luna.model.City city) {
        this.id = id;
        this.Coord = coord;
        this.Weather = weather;
        this.Main = main;
        this.Wind = wind;
        this.Clouds = clouds;
        this.dt = dt;
        this.Sys = sys;
        this.City = city;
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

    public City getCity() { return City; }

    public void setCity(City city) { this.City = city;}

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
