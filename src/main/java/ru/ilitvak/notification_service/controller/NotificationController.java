package ru.ilitvak.notification_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ilitvak.notification_service.model.dto.NotificationDto;
import ru.ilitvak.notification_service.service.NotificationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public List<NotificationDto> getNotifications(@RequestHeader(value = "Authorization") String authHeader) {
        return notificationService.getNotifications(authHeader);
    }

    @PatchMapping("/{id}")
    public NotificationDto readUnreadNotifications(@RequestHeader(value = "Authorization") String authHeader,
                                                   @PathVariable UUID id) {
        return notificationService.readUnreadNotifications(authHeader, id);
    }
}
