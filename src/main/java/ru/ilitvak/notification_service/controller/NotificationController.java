package ru.ilitvak.notification_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilitvak.notification_service.model.dto.NotificationDto;
import ru.ilitvak.notification_service.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public List<NotificationDto> getNotifications(@RequestHeader(value = "Authorization") String authHeader) {
        return notificationService.getNotifications(authHeader);
    }
}
