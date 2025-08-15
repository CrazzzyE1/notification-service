package ru.ilitvak.notification_service.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ilitvak.notification_service.model.entity.Notification;

import java.util.Optional;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    @EntityGraph(value = "event")
    @Query("SELECT n FROM Notification n WHERE n.id = :id")
    Optional<Notification> findByIdWithEvent(@Param("id") UUID id);
}
