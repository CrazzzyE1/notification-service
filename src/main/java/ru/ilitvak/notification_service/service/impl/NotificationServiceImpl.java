package ru.ilitvak.notification_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ilitvak.notification_service.event.EventDto;
import ru.ilitvak.notification_service.manager.EventManager;
import ru.ilitvak.notification_service.manager.NotificationManager;
import ru.ilitvak.notification_service.mapper.EventMapper;
import ru.ilitvak.notification_service.mapper.NotificationMapper;
import ru.ilitvak.notification_service.model.dto.NotificationDto;
import ru.ilitvak.notification_service.service.NotificationService;
import ru.ilitvak.notification_service.util.JwtTokenMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final EventManager eventManager;
    private final NotificationManager notificationManager;
    private final EventMapper eventMapper;
    private final NotificationMapper notificationMapper;

    @Override
    public void handleNotification(EventDto event) {
        eventManager.handle(eventMapper.toEntity(event));
    }

    @Override
    public List<NotificationDto> getNotifications(String authHeader) {
        UUID me = JwtTokenMapper.parseUserId(authHeader);
        return notificationMapper.toListDto(notificationManager.getAllAppBell(me));
    }

    @Override
    public NotificationDto readUnreadNotifications(String authHeader, UUID id) {
        UUID me = JwtTokenMapper.parseUserId(authHeader);
        return notificationMapper.toDto(notificationManager.readUnread(me, id));
    }

    @Override
    public long getNotificationsCount(String authHeader, Boolean unread) {
        UUID me = JwtTokenMapper.parseUserId(authHeader);
        return notificationManager.getCount(me, unread);
    }
}
