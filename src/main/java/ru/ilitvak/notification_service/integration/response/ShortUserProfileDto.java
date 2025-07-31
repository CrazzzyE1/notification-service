package ru.ilitvak.notification_service.integration.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class ShortUserProfileDto {
    private UUID id;
    private String fullName;
    private String location;
    private Boolean isDeleted;
}
