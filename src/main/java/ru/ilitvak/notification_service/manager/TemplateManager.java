package ru.ilitvak.notification_service.manager;

import ru.ilitvak.notification_service.model.entity.EventEntity;
import ru.ilitvak.notification_service.model.entity.Template;

import java.util.Map;

public interface TemplateManager {
    Template get(EventEntity event, String location);

    String fill(Template template, Map<String, String> params);
}
