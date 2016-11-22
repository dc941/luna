package luna.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by pwluft on 2016-10-23.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Clouds {

    @Id
    @GeneratedValue(generator="CloudsSeq")
    @SequenceGenerator(name="CloudsSeq",sequenceName="CLOUDS_SEQ", allocationSize=1)
    @Column(name = "ID")
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
