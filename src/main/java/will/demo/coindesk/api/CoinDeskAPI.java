package will.demo.coindesk.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import will.demo.coindesk.entity.dto.CoinDeskDTO;

/**
 * <p>
 * 外部api
 * </p>
 * @author firegsh
 * @since 2025-05-05 16:05:07
 **/
@Component
@RequiredArgsConstructor
public class CoinDeskAPI {

    private final RestTemplate restTemplate;

    @Value("${coindesk.json}")
    private String jsonUrl;

    public CoinDeskDTO importBitcoinData() {
        return restTemplate.getForObject(jsonUrl, CoinDeskDTO.class);

    }
}
