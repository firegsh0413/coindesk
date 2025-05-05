package will.demo.coindesk.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class BitcoinPriceInfoVO {

    private String chartName;
    private String disclaimer;
    private TimeInfoVO timeInfo;
    private List<BpiCurrencyVO> currencies;
}
