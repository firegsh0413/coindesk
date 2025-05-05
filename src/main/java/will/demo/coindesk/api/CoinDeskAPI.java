package will.demo.coindesk.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import will.demo.coindesk.entity.dto.CoinDeskDTO;

@Component
@RequiredArgsConstructor
public class CoinDeskAPI {

    private final RestTemplate restTemplate;

    @Value("${coindesk.json}")
    private String jsonUrl;

    public CoinDeskDTO importBitcoinData() {
        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.getForObject(jsonUrl, CoinDeskDTO.class);

    }
}
