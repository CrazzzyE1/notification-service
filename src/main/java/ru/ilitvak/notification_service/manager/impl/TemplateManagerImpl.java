package ru.ilitvak.notification_service.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ilitvak.notification_service.exception.NotFoundException;
import ru.ilitvak.notification_service.manager.TemplateManager;
import ru.ilitvak.notification_service.model.entity.EventEntity;
import ru.ilitvak.notification_service.model.entity.Template;
import ru.ilitvak.notification_service.repository.TemplateRepository;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class TemplateManagerImpl implements TemplateManager {

    private final TemplateRepository templateRepository;

    @Override
    public Template get(EventEntity event, String location) {
        return templateRepository.findTemplateByEventTypeAndLocaleAndMethodIn(event.getType(),
                        location, event.getMethods())
                .orElseThrow(() -> new NotFoundException(
                        "Template for event with id %s not found".formatted(event.getId())));
    }

    @Override
    public String fill(Template template, Map<String, String> params) {
        String templateText = template.getTemplateText();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String placeholder = "${" + entry.getKey() + "}";
            templateText = templateText.replace(placeholder, entry.getValue());
        }
        return templateText;
    }
}
