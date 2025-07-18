package com.ilitvak.notification_service.listener;

import com.ilitvak.notification_service.event.NotificationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class FriendsRequestEventListener {

    @KafkaListener(topics = "notifications.friends", groupId = "user-service")
    public void handleNotification(NotificationEvent event) {
        System.out.println("Received user: " + event);
    }
}
