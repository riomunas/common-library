package asia.powerbiz.core.common.vo;

import java.math.BigDecimal;

public record Money(
        BigDecimal value,
        String currency

) {
}
