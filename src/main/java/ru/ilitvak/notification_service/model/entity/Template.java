package ru.ilitvak.notification_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.ilitvak.notification_service.event.EventType;
import ru.ilitvak.notification_service.event.NotificationMethod;

@Getter
@Setter
@Entity
@Table(name = "templates")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventType eventType;

    @Enumerated(EnumType.STRING)
    @Column(name = "method", nullable = false)
    private NotificationMethod method;

    @Column(name = "locale")
    private String locale;

    @Column(name = "template_text")
    private String templateText;
}
