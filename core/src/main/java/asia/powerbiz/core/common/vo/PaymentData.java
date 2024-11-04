package asia.powerbiz.core.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentData {
    private String method;
    private String bank;
    private String number;
    private Money grossAmount;
    private BigDecimal creditLimitUsage;
    private String invoiceUrl;
    private Integer termDays;
}
