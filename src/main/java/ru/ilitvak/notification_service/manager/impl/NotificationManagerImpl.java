package ru.ilitvak.notification_service.manager.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ilitvak.notification_service.exception.NotFoundException;
import ru.ilitvak.notification_service.manager.NotificationManager;
import ru.ilitvak.notification_service.model.entity.EventEntity;
import ru.ilitvak.notification_service.model.entity.Notification;
import ru.ilitvak.notification_service.repository.EventRepository;
import ru.ilitvak.notification_service.repository.NotificationRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static ru.ilitvak.notification_service.event.NotificationMethod.APP_BELL;

@Component
@RequiredArgsConstructor
public class NotificationManagerImpl implements NotificationManager {

    private final EventRepository eventRepository;
    private final NotificationRepository notificationRepository;

    @Override
    public List<EventEntity> getAllAppBell(UUID me) {
        return eventRepository.findAllByRecipientIdAndMethod(me, APP_BELL);
    }

    @Override
    @Transactional
    public Notification readUnread(UUID me, UUID id) {
        Notification notification = notificationRepository.findByIdWithEvent(id)
                .orElseThrow(() -> new NotFoundException("Notification with id " + id + " not found"));

        UUID recipientId = notification.getEvent().getRecipientId();
        if (Objects.equals(me, recipientId)) {
            notification.setRead(!notification.getRead());
        }
        return notification;
    }

    @Override
    public long getCount(UUID me, Boolean unread) {
        return eventRepository.countUnreadByRecipientAndMethod(me, APP_BELL, unread);
    }
}
