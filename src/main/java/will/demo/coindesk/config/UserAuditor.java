package will.demo.coindesk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * <p>
 * temp 取得user
 * </p>
 * @author firegsh
 * @since 2025-05-05 16:05:46
 **/
@Configuration
public class UserAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("test");
    }
}
