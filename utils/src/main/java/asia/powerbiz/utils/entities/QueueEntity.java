package asia.powerbiz.utils.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "c_queue")
public class QueueEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    private String aggregateId;
    private String requestId;
    private String eventType;

    @Column(columnDefinition = "TEXT")
    private String payload;

    @Column(columnDefinition = "timestamp with time zone default now()")
    @CreationTimestamp
    private OffsetDateTime createdAt;

    public QueueEntity(UUID id, String aggregateId, String requestId,String eventType, String payload, Instant createdAt){
        this.id = id;
        this.aggregateId = aggregateId;
        this.requestId = requestId;
        this.eventType = eventType;
        this.payload = payload;
        this.createdAt = OffsetDateTime.ofInstant(createdAt, ZoneOffset.UTC);

    }
}