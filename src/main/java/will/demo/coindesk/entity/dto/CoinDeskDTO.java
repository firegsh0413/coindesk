package will.demo.coindesk.entity.dto;

import lombok.Data;
import will.demo.coindesk.entity.model.BpiCurrency;
import will.demo.coindesk.entity.model.TimeInfo;

import java.util.Map;

@Data
public class CoinDeskDTO {
    private TimeInfo time;
    private String disclaimer;
    private String chartName;
    private Map<String, BpiCurrency> bpi;
}
