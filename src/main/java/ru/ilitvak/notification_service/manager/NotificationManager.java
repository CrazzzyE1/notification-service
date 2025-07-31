package ru.ilitvak.notification_service.manager;

import ru.ilitvak.notification_service.model.entity.EventEntity;

import java.util.List;
import java.util.UUID;

public interface NotificationManager {
    List<EventEntity> getAllAppBell(UUID me);
}
