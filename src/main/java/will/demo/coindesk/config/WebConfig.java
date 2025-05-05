package will.demo.coindesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 網路設定
 * </p>
 * @author firegsh
 * @since 2025-05-03 17:05:14
 **/
@Configuration
public class WebConfig {

    /**
     * <p>
     * spring boot 1.4以後版本不提供默認resttemplate bean實例
     * </p>
     * @author firegsh
     * @since 2025-05-03 17:05:53
     **/
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
