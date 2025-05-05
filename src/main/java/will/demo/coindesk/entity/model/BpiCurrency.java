package will.demo.coindesk.entity.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <p>
 * 幣別匯率
 * </p>
 * @author firegsh
 * @since 2025-05-02 16:05:19
 **/
@Data
public class BpiCurrency {

    private String code;
    private String symbol;
    private String rate;
    private String description;
    @JsonProperty("rate_float")
    private Double rateFloat;
}
