package asia.powerbiz.core.channel.shopee.model;

import asia.powerbiz.core.channel.shopee.dto.OrderNotificationRequestDto;
import asia.powerbiz.core.common.model.EventMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CreateOrderEvent extends EventMessage<OrderNotificationRequestDto> {

    @Serial
    private static final long serialVersionUID = 3937464348836050565L;

    private String orderId;
    private OrderNotificationRequestDto orderNotification;

    public CreateOrderEvent(UUID id, OrderNotificationRequestDto data) {
        super(id.toString(), data);
    }

}
