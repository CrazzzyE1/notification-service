package ru.ilitvak.notification_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ilitvak.notification_service.event.EventDto;
import ru.ilitvak.notification_service.manager.EventManager;
import ru.ilitvak.notification_service.mapper.EventMapper;
import ru.ilitvak.notification_service.service.NotificationService;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final EventManager eventManager;
    private final EventMapper eventMapper;

    @Override
    public void handleNotification(EventDto event) {
        eventManager.handle(eventMapper.toEntity(event));
    }
}
