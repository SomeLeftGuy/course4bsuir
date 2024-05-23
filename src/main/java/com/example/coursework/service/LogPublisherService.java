package com.example.coursework.service;

import com.example.coursework.model.enums.EventName;
import com.example.coursework.model.event.CreateAuditLogEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogPublisherService {

    private final ApplicationEventPublisher publisher;

    public void createAuditLog(EventName eventName, String details ){
        var event = new CreateAuditLogEvent();
        event.setEventName(eventName);
        event.setDetails(details);
        publisher.publishEvent(event);
    }
}
