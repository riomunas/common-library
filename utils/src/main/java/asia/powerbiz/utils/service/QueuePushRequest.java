package asia.powerbiz.utils.service;

import asia.powerbiz.utils.entities.QueueEntity;
import asia.powerbiz.utils.repositories.QueueRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class QueuePushRequest {
    private final RabbitTemplate rabbitTemplate;
    private final QueueRepository queueRepository;
    private final ObjectMapper objectMapper;

    @Value("${app.message_broker.recmd_queue.name}")
    private String reQueueName;

    @Value("${app.message_broker.cmd_queue.name}")
    private String commandQueueName;

    public void sendToCommandQueue(Object message){
        try {
            log.debug("Send message to queue: {}", commandQueueName);
            rabbitTemplate.convertAndSend(commandQueueName, message);
        } catch (Exception e) {
            log.error("QueuePushRequest::sendToCommandQueue error {}", e.getMessage());
        }
    }

    public void sendToReQueue(Object message){
        try {
            log.debug("Send message to queue: {}", reQueueName);
            rabbitTemplate.convertAndSend(reQueueName, message);
        } catch (Exception e) {
            log.error("QueuePushRequest::sendToReQueue error {}", e.getMessage());
        }
    }

    public void reSendRequestEvent(String aggregateId){
        Optional<QueueEntity> results = queueRepository
                .findFirstByAggregateIdOrderByCreatedAtAsc(aggregateId);
        if (results.isPresent()) {
            QueueEntity queueEntity = results.get();
            convertAndSendToCommandReQueue(queueEntity.getPayload(), queueEntity.getEventType());
        }
    }

    public boolean isAggregateIdExistInQueue(String aggregateId){
        return queueRepository.findFirstByAggregateIdOrderByCreatedAtAsc(aggregateId).isPresent();
    }


    public void deleteByRequestIdFromQueueTable(String requestId){
        queueRepository.deleteByRequestId(requestId);
    }

    public void convertAndSendToCommandReQueue(String message, String className){
        try {
            Object messageToBeSend =
                    objectMapper
                            .readValue(message, Class.forName(className));
            rabbitTemplate.convertAndSend(reQueueName, messageToBeSend);
        } catch (Exception e) {
            log.error("QueuePushRequest::sendToCommandQueue error {}", e.getMessage());
        }
    }

    public void convertAndSendToCommandQueue(String message, String className){
        try {
            log.debug("Send message to queue: {}", commandQueueName);
            Object messageToBeSend =
                    objectMapper
                            .readValue(message, Class.forName(className));
            rabbitTemplate.convertAndSend(commandQueueName, messageToBeSend);
        } catch (Exception e) {
            log.error("QueuePushRequest::sendToCommandQueue error {}", e.getMessage());
        }
    }

    public void sendToQueueTable(String aggregateId, String requestId, String className, String payload, Instant createdAt){
        queueRepository.saveAndFlush(new QueueEntity(
                UUID.randomUUID(),
                aggregateId,
                requestId,
                className,
                payload,
                createdAt
        ));
    }
}
