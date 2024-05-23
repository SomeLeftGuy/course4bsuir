package com.example.coursework.service;

import com.example.coursework.model.entity.Logs;
import com.example.coursework.model.event.CreateAuditLogEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LogConsumerService {
    private final LogService service;
    private final EmployeeService employeeService;

    @EventListener(CreateAuditLogEvent.class)
    public void onCreateLogEvent(CreateAuditLogEvent event) {
        var employee = employeeService.getCurrentUser();

        var entity = new Logs().builder()
                .createdDate(LocalDate.now())
                .eventName(event.getEventName())
                .details(event.getDetails())
                .employee(employee)
                .build();

        service.createLog(entity);
    }
}
