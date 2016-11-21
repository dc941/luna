package luna.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by DC on 2016-11-01.
 */

@Entity
public class City {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNTRYCODE")
    private String countryCode;

    public City(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public City(){};

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
