package luna.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String main;
    private String description;

    public Weather(Long id, String main, String description) {
        this.id = id;
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
}
