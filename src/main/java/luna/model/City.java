package luna.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by DC on 2016-11-01.
 */

@Entity
public class City {

    @Id
    @GeneratedValue(generator="CitySeq")
    @SequenceGenerator(name="CitySeq",sequenceName="CITY_SEQ", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNTRYCODE")
    private String countryCode;

    @Column(name = "ACTIVE")
    private String active;

    public City(String name, String countryCode, String active) {
        this.name = name;
        this.countryCode = countryCode;
        this.active = active;
    }

    public City(){};

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getActive() { return active; }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setActive(String active) { this.active = active; }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
