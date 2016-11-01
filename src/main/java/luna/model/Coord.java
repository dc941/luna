package luna.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Coord {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private Double lon;

    @NotNull
    private Double lat;

    public Coord() {
    }

    public Coord(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Long getId() {
        return id;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "id=" + id +
                ", lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
