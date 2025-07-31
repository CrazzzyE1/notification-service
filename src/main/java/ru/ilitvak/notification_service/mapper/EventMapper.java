package ru.ilitvak.notification_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ilitvak.notification_service.event.EventDto;
import ru.ilitvak.notification_service.model.entity.EventEntity;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "notifications", ignore = true)
    EventEntity toEntity(EventDto dto);
}
