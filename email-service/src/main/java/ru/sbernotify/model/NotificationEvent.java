package ru.sbernotify.model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEvent {
    private UUID id;
    private NotificationType type;
    private String recipient;
    private String subject;
    private String message;
    private LocalDateTime createdAt;
}
