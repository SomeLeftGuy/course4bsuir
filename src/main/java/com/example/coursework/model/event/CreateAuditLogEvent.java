package com.example.coursework.model.event;

import com.example.coursework.model.enums.EventName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuditLogEvent {
    private EventName eventName;
    private String details;
}
