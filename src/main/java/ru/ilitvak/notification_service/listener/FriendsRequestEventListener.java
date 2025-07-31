package ru.ilitvak.notification_service.listener;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.ilitvak.notification_service.event.EventDto;
import ru.ilitvak.notification_service.service.NotificationService;


@Slf4j
@Component
@RequiredArgsConstructor
public class FriendsRequestEventListener {

    private final NotificationService notificationService;

    @KafkaListener(topics = "notifications.friends", groupId = "user-service")
    public void handleNotification(@Valid @Payload EventDto event) {
        notificationService.handleNotification(event);
    }
}
