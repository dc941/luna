package luna.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
public class Main {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //temp is in Kelvin
    @NotNull
    private Double temp;

    //pressure is in hPa
    @NotNull
    private Double pressure;

    //humidity is in percent
    @NotNull
    private Integer humidity;

    public Main(Long id, Double temp, Double pressure, Integer humidity) {
        this.id = id;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Long getId() {
        return id;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
}
