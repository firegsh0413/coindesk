package will.demo.coindesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import will.demo.coindesk.entity.CurrencyInfo;

public interface CurrencyInfoRepository extends JpaRepository<CurrencyInfo, Long> {
}
