package ru.ilitvak.notification_service.manager;

import ru.ilitvak.notification_service.model.entity.EventEntity;

public interface EventManager {
    void handle(EventEntity event);
}
