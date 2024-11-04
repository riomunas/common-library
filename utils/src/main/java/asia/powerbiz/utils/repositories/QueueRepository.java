package asia.powerbiz.utils.repositories;

import asia.powerbiz.utils.entities.QueueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface QueueRepository extends JpaRepository<QueueEntity, UUID> {

    Optional<QueueEntity> findFirstByAggregateIdOrderByCreatedAtAsc(String aggregateId);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("delete from QueueEntity q where q.requestId = ?1")
    void deleteByRequestId(String requestId);

}