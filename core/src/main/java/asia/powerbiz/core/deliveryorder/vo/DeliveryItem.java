package asia.powerbiz.core.deliveryorder.vo;

import asia.powerbiz.core.common.vo.Money;
import asia.powerbiz.core.inventory.constant.BookingState;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryItem {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String catalogId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String sku;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    private Integer quantity;

    private String uom;

    private Money sellingPrice;

    private Money subTotal;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String orderItemReferenceId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BookingState bookingState;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String batchNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String expiredDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String serialNumber;

    private String imageUrl;

    private Boolean productMapped = true;
}
