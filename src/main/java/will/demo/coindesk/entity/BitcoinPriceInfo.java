package will.demo.coindesk.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class BitcoinPriceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chartName;
    private String disclaimer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_info_id", referencedColumnName = "id")
    private TimeInfo timeInfo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_info_id")
    private List<BpiCurrency> currencies;
}
