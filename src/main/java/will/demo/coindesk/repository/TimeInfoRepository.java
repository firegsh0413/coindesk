package will.demo.coindesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import will.demo.coindesk.entity.TimeInfo;

public interface TimeInfoRepository extends JpaRepository<TimeInfo, Long> {
}
