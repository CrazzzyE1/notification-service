package ru.ilitvak.notification_service.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ilitvak.notification_service.event.NotificationMethod;
import ru.ilitvak.notification_service.model.entity.EventEntity;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<EventEntity, UUID> {
    @EntityGraph(value = "notifications")
    @Query("SELECT e FROM EventEntity e WHERE e.recipientId = :recipientId AND :method MEMBER OF e.methods")
    List<EventEntity> findAllByRecipientIdAndMethod(@Param("recipientId") UUID recipientId,
                                                    @Param("method") NotificationMethod method);
}
