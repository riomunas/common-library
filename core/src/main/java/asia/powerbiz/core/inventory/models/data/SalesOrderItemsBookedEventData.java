package asia.powerbiz.core.inventory.models.data;

import asia.powerbiz.core.common.vo.Channel;
import asia.powerbiz.core.inventory.constant.BookingState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesOrderItemsBookedEventData implements Serializable {
    @Serial
    private static final long serialVersionUID = 321760116029103115L;

    private String id;
    private String nomor;
    private String referenceId;
    private String businessId;
    private String warehouseId;
    private int locationId;
    private Channel channel;
    private String movementType;
    private List<BookingItem> items;
    private List<BundlingItem> bundlingItems;
    private Summary summary;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookingItem{
        private String inventoryMovementId;
        private UUID lineId;
        private UUID catalogId;
        private UUID productId;
        private String businessId;
        private Integer availableQuantity;
        private Integer allocatedQuantity;
        private Integer onhandQuantity;
        private Integer movementQuantity;
        private Integer bookedQuantity;
        private String uom;
        private UUID inventoryId;
        private String batchNumber;
        private Date expiredDate;
        private BookingState status;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BundlingItem{
        private String inventoryMovementId;
        private UUID refLineId;
        private UUID catalogId;
        private UUID productId;
        private Integer availableQuantity;
        private Integer allocatedQuantity;
        private Integer onhandQuantity;
        private Integer inputQuantity;
        private String uom;
        private UUID inventoryId;
    }


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Summary{
        private String orderInventoryStatus;
        private List<OrderLineItem> orderLineItems;
    }


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderLineItem{
        private UUID lineItemId;
        private UUID catalogId;
        private String inventoryStatus;
    }
}
