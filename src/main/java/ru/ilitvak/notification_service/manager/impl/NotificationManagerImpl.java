package ru.ilitvak.notification_service.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ilitvak.notification_service.manager.NotificationManager;
import ru.ilitvak.notification_service.model.entity.EventEntity;
import ru.ilitvak.notification_service.repository.EventRepository;

import java.util.List;
import java.util.UUID;

import static ru.ilitvak.notification_service.event.NotificationMethod.APP_BELL;

@Component
@RequiredArgsConstructor
public class NotificationManagerImpl implements NotificationManager {

    private final EventRepository eventRepository;

    @Override
    public List<EventEntity> getAllAppBell(UUID me) {
        return eventRepository.findAllByRecipientIdAndMethod(me, APP_BELL);
    }
}
