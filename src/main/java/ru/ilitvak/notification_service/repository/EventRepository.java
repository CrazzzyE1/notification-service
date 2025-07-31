package ru.ilitvak.notification_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilitvak.notification_service.model.entity.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
