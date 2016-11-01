package luna.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Weather {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String main;
    private String description;

    public Weather(String main, String description) {
        this.main = main;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
