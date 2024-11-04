package asia.powerbiz.utils.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "c_event_request_log")
@NoArgsConstructor
public class EventRequestLogEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String eventType;
    private String appName;

    @Column(columnDefinition = "TEXT")
    private String payload;

    @Column(columnDefinition = "timestamp with time zone default now()")
    @CreationTimestamp
    private OffsetDateTime createdAt;

    public EventRequestLogEntity(String eventType, String payload, String appName){
        this.id = UUID.randomUUID().toString();
        this.eventType = eventType;
        this.payload = payload;
        this.appName = appName;
    }
}