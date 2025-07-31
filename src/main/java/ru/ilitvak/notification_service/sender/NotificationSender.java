package ru.ilitvak.notification_service.sender;

import ru.ilitvak.notification_service.event.NotificationMethod;
import ru.ilitvak.notification_service.model.entity.EventEntity;

import java.util.List;

public interface NotificationSender {
    boolean isSupport(List<NotificationMethod> methods);

    void send(EventEntity event);
}
