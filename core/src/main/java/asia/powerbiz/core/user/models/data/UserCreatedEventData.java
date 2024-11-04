package asia.powerbiz.core.user.models.data;

public record UserCreatedEventData(
        String userId,
        String userRegistrationId,
        String userName,
        String userEmail,
        String referenceCode

) {
}
