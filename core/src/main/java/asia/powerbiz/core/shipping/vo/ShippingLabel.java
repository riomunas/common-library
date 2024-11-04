package asia.powerbiz.core.shipping.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingLabel {
    private String url;

    /**
     * type can be `html`, `image` or `pdf`
     */
    private ShippingLabelType type = ShippingLabelType.HTML;

    /**
     * JSON string of attributes
     */
    private String attributes;

    public static enum ShippingLabelType {
        HTML("html"),
        IMAGE("image"),
        PDF("pdf");

        private String type;

        ShippingLabelType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return this.type;
        }
    }
}