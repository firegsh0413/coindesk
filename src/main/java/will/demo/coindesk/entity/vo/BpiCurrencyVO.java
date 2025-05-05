package will.demo.coindesk.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import will.demo.coindesk.entity.model.BpiCurrency;

@EqualsAndHashCode(callSuper = true)
@Data
public class BpiCurrencyVO extends BpiCurrency {

    private String name;
}
