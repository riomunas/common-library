package asia.powerbiz.core.business.models.data;

public record UserInvitedEventData(
        String workspaceId,
        String invitedUserId
) {
}
