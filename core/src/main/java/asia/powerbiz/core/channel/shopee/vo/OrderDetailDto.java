package asia.powerbiz.core.channel.shopee.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderDetailDto {
    private String orderNumber;
    private String orderState;
    private CustomerInfo customerInfo;
    private DestinationData destinationData;
    private ShipmentData shipmentData;
    private List<Item> items = new ArrayList<>();
    private Integer subTotal;
    private Integer discount;
    private Integer grossTotal;
    private String orderDate;
    private String currency;
    private List<OrderHistory> orderHistory = null;

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CustomerInfo {

        private String name;
        private String address;
        private String city;
        private String postalCode;
        private String phone;
        private String email;
    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class DestinationData {

        private String name;
        private String address;
        private String subDistrict;
        private String district;
        private String city;
        private String province;
        private String country;
        private Integer postalCode;
        private String phone;

    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public class ShipmentData {

        private String id;
        private Integer destId;
        private String name;
        private String service;
        private Integer cost;
        private Integer insuranceCost;
        private String trackingNo;
        private String pickupAddress;
    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public class Item {

        private String id;
        private String catalogId;
        private String title;
        private String uom;
        private String sku;
        private Integer qty;
        private Integer sellingPrice;
        private String imageUrl;
    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public class OrderHistory {

        private String orderStatus;
        private String updateTime;
    }
}
