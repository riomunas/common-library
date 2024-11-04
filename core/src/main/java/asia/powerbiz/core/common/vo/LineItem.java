package asia.powerbiz.core.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItem {
    private UUID id;
    private UUID catalogId;
    private String lineItemReferenceId;
    private String sku;
    private String title;
    private Integer quantity;
    private String uom;
    private Money masterPrice;
    private Money sellingPrice;
    private Money discount;
    private Money channelDiscount;
    private Money subTotal;
    private Boolean confirmed;
    private String remarks;
    private String imageUrl;
}