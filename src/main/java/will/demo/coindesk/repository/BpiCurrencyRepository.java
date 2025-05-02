package will.demo.coindesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import will.demo.coindesk.entity.BpiCurrency;

public interface BpiCurrencyRepository extends JpaRepository<BpiCurrency, Long> {
}
