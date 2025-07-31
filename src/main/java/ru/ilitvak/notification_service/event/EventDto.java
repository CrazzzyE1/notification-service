package ru.ilitvak.notification_service.event;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    @NotNull
    private UUID id;
    @NotNull
    private Instant created;
    @NotNull
    private UUID senderId;
    private UUID recipientId;
    @NotNull
    private EventType type;
    @NotNull
    private String entityId;
    @NotEmpty
    private List<NotificationMethod> methods;
}
