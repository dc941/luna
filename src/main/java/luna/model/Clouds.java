package luna.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Clouds {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //Cloudiness in %
    @NotNull
    private Integer all;

    public Clouds(Integer all) {
        this.all = all;
    }

    public Long getId() {
        return id;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "id=" + id +
                ", all=" + all +
                '}';
    }
}
