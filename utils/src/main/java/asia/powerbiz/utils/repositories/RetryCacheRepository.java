package asia.powerbiz.utils.repositories;

import asia.powerbiz.utils.entities.RetryCacheEntity;

import java.util.List;
import java.util.Optional;

public interface RetryCacheRepository {
    void save(RetryCacheEntity entity);
    Optional<RetryCacheEntity> findById(String id);
    List<String> findAllKey();
    void deleteIdIn(List<String> ids);
}
