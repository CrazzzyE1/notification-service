package ru.ilitvak.notification_service.sender.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ilitvak.notification_service.event.NotificationMethod;
import ru.ilitvak.notification_service.integration.UserServiceFacade;
import ru.ilitvak.notification_service.integration.response.ShortUserProfileDto;
import ru.ilitvak.notification_service.manager.TemplateManager;
import ru.ilitvak.notification_service.model.entity.EventEntity;
import ru.ilitvak.notification_service.model.entity.Notification;
import ru.ilitvak.notification_service.model.entity.Template;
import ru.ilitvak.notification_service.repository.NotificationRepository;
import ru.ilitvak.notification_service.sender.NotificationSender;

import java.util.List;
import java.util.Map;

import static ru.ilitvak.notification_service.constant.Constant.DEFAULT_LOCATION_CODE;
import static ru.ilitvak.notification_service.event.NotificationMethod.APP_BELL;

@Component
@RequiredArgsConstructor
public class AppBellSender implements NotificationSender {

    private final TemplateManager templateManager;
    private final UserServiceFacade userServiceFacade;
    private final NotificationRepository notificationRepository;

    @Override
    public boolean isSupport(List<NotificationMethod> methods) {
        return methods.contains(APP_BELL);
    }

    @Override
    @Transactional
    public void send(EventEntity event) {
        ShortUserProfileDto info = userServiceFacade.getShortUserProfile(event.getSenderId());
        String location = info.getLocation() != null ? info.getLocation() : DEFAULT_LOCATION_CODE;
        Template template = templateManager.get(event, location);
        String text = templateManager.fill(template, Map.of("senderFullName", info.getFullName()));
        event.getNotifications().add(createNotification(event, text));
    }

    private Notification createNotification(EventEntity event, String text) {
        Notification notification = new Notification();
        notification.setEvent(event);
        notification.setText(text);
        notification.setRead(false);
        notification.setType(APP_BELL);
        notificationRepository.save(notification);
        return notification;
    }
}
