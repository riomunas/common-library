package asia.powerbiz.filterauthorizationkeycloack.repositories.redis;

import asia.powerbiz.filterauthorizationkeycloack.entities.redis.UserWorkspaceAccess;

import java.util.Optional;

public interface WorkspaceRepository {
    Optional<UserWorkspaceAccess> findById(String id);
}
