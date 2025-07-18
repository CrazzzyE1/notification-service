package com.ilitvak.notification_service.event;

import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEvent {
    private UUID eventId;
    private Instant eventDateTime;
    private UUID senderId;
    private UUID recipientId;
    private EventType eventType;
    private String entityId;
    private List<NotificationMethod> notificationMethods;
}
