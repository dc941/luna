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
public class Wind {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //wind speed in meters per second
    @NotNull
    private Double speed;

    //metereological direction
    @NotNull
    private Double deg;

    public Wind(Double speed, Double deg) {
        this.speed = speed;
        this.deg = deg;
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
