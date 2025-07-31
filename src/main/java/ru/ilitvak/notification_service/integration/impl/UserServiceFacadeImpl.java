package ru.ilitvak.notification_service.integration.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.ilitvak.notification_service.integration.UserServiceFacade;
import ru.ilitvak.notification_service.integration.response.ShortUserProfileDto;

import java.util.UUID;

@Component
public class UserServiceFacadeImpl implements UserServiceFacade {


    private final RestTemplate restTemplate;

    public UserServiceFacadeImpl(@Qualifier(value = "user-service") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ShortUserProfileDto getShortUserProfile(UUID id) {
        return restTemplate.getForObject(
                "http://USER-SERVICE/api/v1/profiles/{id}/short",
                ShortUserProfileDto.class,
                id
        );
    }
}
