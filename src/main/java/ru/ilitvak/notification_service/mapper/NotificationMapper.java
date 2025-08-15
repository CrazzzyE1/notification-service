package ru.ilitvak.notification_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.ilitvak.notification_service.model.dto.NotificationDto;
import ru.ilitvak.notification_service.model.entity.EventEntity;
import ru.ilitvak.notification_service.model.entity.Notification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static ru.ilitvak.notification_service.event.NotificationMethod.APP_BELL;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    @Mapping(target = "senderId", source = "senderId")
    @Mapping(target = "text", source = ".", qualifiedByName = "getText")
    @Mapping(target = "isRead", source = ".", qualifiedByName = "isRead")
    @Mapping(target = "id", source = ".", qualifiedByName = "setNotificationId")
    NotificationDto toDto(EventEntity entity);

    @Mapping(target = "type", ignore = true)
    @Mapping(target = "senderId", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "isRead", source = "read")
    NotificationDto toDto(Notification entity);

    List<NotificationDto> toListDto(List<EventEntity> entity);

    @Named("getText")
    default String getText(EventEntity entity) {
        Optional<Notification> optional = entity.getNotifications().stream()
                .filter(n -> APP_BELL.equals(n.getType()))
                .findFirst();
        if (optional.isPresent()) {
            return optional.get().getText();
        }
        return "";
    }

    @Named("isRead")
    default boolean isRead(EventEntity entity) {
        return entity.getNotifications().stream()
                .filter(n -> APP_BELL.equals(n.getType()))
                .findFirst()
                .map(notification -> TRUE.equals(notification.getRead())).orElse(FALSE);
    }

    @Named("setNotificationId")
    default UUID setNotificationId(EventEntity entity) {
        return entity.getNotifications().stream()
                .filter(n -> APP_BELL.equals(n.getType()))
                .findFirst()
                .map(Notification::getId).orElse(null);
    }
}