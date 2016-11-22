package luna.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Wind {

    @Id
    @GeneratedValue(generator="WindSeq")
    @SequenceGenerator(name="WindSeq",sequenceName="WIND_SEQ", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    //wind speed in meters per second
    @NotNull
    @Column(name = "SPEED")
    private Double speed;

    //metereological direction
    @NotNull
    @Column(name = "DEG")
    private Double deg;

    public Wind(Double speed, Double deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Wind() {
    }

    public Long getId() {
        return id;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "id=" + id +
                ", speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
