package will.demo.coindesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import will.demo.coindesk.entity.BitcoinPriceInfo;

public interface BitcoinPriceInfoRepository extends JpaRepository<BitcoinPriceInfo, Long> {
}
