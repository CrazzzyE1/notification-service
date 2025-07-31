package ru.ilitvak.notification_service.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ilitvak.notification_service.manager.EventManager;
import ru.ilitvak.notification_service.model.entity.EventEntity;
import ru.ilitvak.notification_service.repository.EventRepository;
import ru.ilitvak.notification_service.sender.NotificationSender;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventManagerImpl implements EventManager {

    private final EventRepository eventRepository;
    private final List<NotificationSender> senders;

    @Override
    public void handle(EventEntity event) {
        EventEntity saved = eventRepository.save(event);
        senders.stream()
                .filter(s -> s.isSupport(saved.getMethods()))
                .forEach(s -> s.send(saved));

    }
}
