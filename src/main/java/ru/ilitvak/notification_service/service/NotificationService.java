package ru.ilitvak.notification_service.service;

import ru.ilitvak.notification_service.event.EventDto;
import ru.ilitvak.notification_service.model.dto.NotificationDto;

import java.util.List;

public interface NotificationService {
    void handleNotification(EventDto event);

    List<NotificationDto> getNotifications(String authHeader);
}
