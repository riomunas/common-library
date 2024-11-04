package asia.powerbiz.utils.repositories;

import asia.powerbiz.utils.entities.EventRequestLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRequestLogRepository extends JpaRepository<EventRequestLogEntity, String> {
}