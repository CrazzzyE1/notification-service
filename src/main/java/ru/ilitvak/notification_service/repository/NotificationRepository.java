package ru.ilitvak.notification_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilitvak.notification_service.model.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
