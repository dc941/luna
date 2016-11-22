package luna.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Main {

    @Id
    @GeneratedValue(generator="MainSeq")
    @SequenceGenerator(name="MainSeq",sequenceName="MAIN_SEQ", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    //temp is in Kelvin
    @NotNull
    @Column(name = "TEMP")
    private Double temp;

    //pressure is in hPa
    @NotNull
    @Column(name = "PRESSURE")
    private Double pressure;

    //humidity is in percent
    @NotNull
    @Column(name = "HUMIDITY")
    private Integer humidity;

    public Main(Double temp, Double pressure, Integer humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Main() {
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

    @Override
    public String toString() {
        return "Main{" +
                "id=" + id +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
