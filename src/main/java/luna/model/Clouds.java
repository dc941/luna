package luna.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
public class Clouds {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //Cloudiness in %
    @NotNull
    private Integer all;

    public Clouds(Long id, Integer all) {
        this.id = id;
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
}
