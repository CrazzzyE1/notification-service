package ru.ilitvak.notification_service.integration;

import ru.ilitvak.notification_service.integration.response.ShortUserProfileDto;

import java.util.UUID;

public interface UserServiceFacade {

    ShortUserProfileDto getShortUserProfile(UUID id);
}
