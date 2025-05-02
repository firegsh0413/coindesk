package will.demo.coindesk.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class CurrencyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currencyCode;
    private String cName;
    @CreatedDate
    private LocalDateTime createDate;
    @CreatedBy
    private String createUser;
    @LastModifiedDate
    private LocalDateTime updateDate;
    @LastModifiedBy
    private String updateUser;
}
