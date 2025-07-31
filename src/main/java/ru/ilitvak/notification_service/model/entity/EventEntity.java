package ru.ilitvak.notification_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.ilitvak.notification_service.event.EventType;
import ru.ilitvak.notification_service.event.NotificationMethod;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    private UUID id;

    @Column(name = "created", nullable = false, updatable = false)
    private Instant created;

    @Column(name = "sender_id", nullable = false, updatable = false)
    private UUID senderId;

    @Column(name = "recipient_id", nullable = false, updatable = false)
    private UUID recipientId;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false, updatable = false)
    private EventType type;

    @Column(name = "entity_id", nullable = false, updatable = false)
    private String entityId;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "event_notification_methods",
            joinColumns = @JoinColumn(name = "event_id")
    )
    @Column(name = "method", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<NotificationMethod> methods = new ArrayList<>();
}
