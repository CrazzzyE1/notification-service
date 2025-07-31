package ru.ilitvak.notification_service.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import ru.ilitvak.notification_service.event.EventType;

import java.util.UUID;

@Getter
@Setter
public class NotificationDto {
    private UUID senderId;
    private String text;
    @JsonProperty("isRead")
    private Boolean isRead;
    private EventType type;
}
