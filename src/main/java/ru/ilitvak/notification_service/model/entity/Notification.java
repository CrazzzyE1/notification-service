package ru.ilitvak.notification_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.ilitvak.notification_service.event.NotificationMethod;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private EventEntity event;

    @Enumerated(EnumType.STRING)
    @Column(name = "method", nullable = false, updatable = false)
    private NotificationMethod type;

    @Column(name = "text", nullable = false, updatable = false)
    private String text;

    @Column(name = "read", nullable = false)
    private Boolean read;
}
