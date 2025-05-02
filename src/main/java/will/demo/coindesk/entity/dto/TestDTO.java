package will.demo.coindesk.entity.dto;

import lombok.Data;
import will.demo.coindesk.entity.BpiCurrency;
import will.demo.coindesk.entity.TimeInfo;

import java.util.Map;

@Data
public class TestDTO {
    private TimeInfo time;
    private String disclaimer;
    private String chartName;
    private Map<String, BpiCurrency> bpi;
}
