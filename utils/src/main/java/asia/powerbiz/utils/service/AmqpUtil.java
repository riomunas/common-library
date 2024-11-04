package asia.powerbiz.utils.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;

import java.util.Optional;

@Slf4j
public class AmqpUtil {
    public static Message setRetrySequence(Message message, String retrySequenceProperty){
        Message newMessage = new Message(message.getBody());
        newMessage.getMessageProperties().setHeaders(message.getMessageProperties().getHeaders());
        var sequence = message.getMessageProperties().getHeaders().get(retrySequenceProperty);
        Optional<Object> seq = Optional.ofNullable(sequence);
        if (seq.isPresent()){
            newMessage.getMessageProperties().getHeaders().replace(retrySequenceProperty, Integer.parseInt(seq.get().toString())+1);
        } else {
            newMessage.getMessageProperties().getHeaders().put(retrySequenceProperty, 0);
        }
        return newMessage;
    }

}
