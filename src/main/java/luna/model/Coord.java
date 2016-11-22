package luna.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Coord {

    @Id
    @GeneratedValue(generator="CoordSeq")
    @SequenceGenerator(name="CoordSeq",sequenceName="COORD_SEQ", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "LON")
    private Double lon;

    @NotNull
    @Column(name = "LAT")
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
