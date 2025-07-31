package ru.ilitvak.notification_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilitvak.notification_service.event.EventType;
import ru.ilitvak.notification_service.event.NotificationMethod;
import ru.ilitvak.notification_service.model.entity.Template;

import java.util.Collection;
import java.util.Optional;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    Optional<Template> findTemplateByEventTypeAndLocaleAndMethodIn(EventType eventType, String locale,
                                                                   Collection<NotificationMethod> method);
}
