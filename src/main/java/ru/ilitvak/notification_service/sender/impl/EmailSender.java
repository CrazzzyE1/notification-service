package ru.ilitvak.notification_service.sender.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.ilitvak.notification_service.event.NotificationMethod;
import ru.ilitvak.notification_service.integration.UserServiceFacade;
import ru.ilitvak.notification_service.model.entity.EventEntity;
import ru.ilitvak.notification_service.repository.TemplateRepository;
import ru.ilitvak.notification_service.sender.NotificationSender;

import java.util.List;

import static ru.ilitvak.notification_service.event.NotificationMethod.EMAIL;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailSender implements NotificationSender {

    private final TemplateRepository templateRepository;
    private final UserServiceFacade userServiceFacade;

    @Override
    public boolean isSupport(List<NotificationMethod> methods) {
        return methods.contains(EMAIL);
    }

    @Override
    public void send(EventEntity event) {
        log.warn("Email sending is not supported");
    }
}
