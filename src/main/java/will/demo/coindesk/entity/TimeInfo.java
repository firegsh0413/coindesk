package will.demo.coindesk.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TimeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String updated;
    @JsonProperty("updatedISO")
    private String updatedISO;
    private String updateduk;
}
