package will.demo.coindesk.entity.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
public class TimeInfo {

    private String updated;
    @JsonProperty("updatedISO")
    private String updatedISO;
    private String updateduk;
}
