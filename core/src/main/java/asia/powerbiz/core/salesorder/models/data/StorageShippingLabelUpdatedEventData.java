package asia.powerbiz.core.salesorder.models.data;

import java.util.UUID;

public record StorageShippingLabelUpdatedEventData(
        UUID id,
        String storageUrl
) {
}
