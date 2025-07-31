package ru.ilitvak.notification_service.service;

import ru.ilitvak.notification_service.event.EventDto;

public interface NotificationService {
    void handleNotification(EventDto event);
}
