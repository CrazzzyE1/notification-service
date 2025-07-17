package com.ilitvak.notification_service.listener;

import com.ilitvak.notification_service.event.FriendRequestEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class FriendsRequestEventListener {

    @KafkaListener(topics = "notifications.friends", groupId = "user-service")
    public void handleNotification(FriendRequestEvent event) {
        System.out.println("Received user: " + event);
    }
}
