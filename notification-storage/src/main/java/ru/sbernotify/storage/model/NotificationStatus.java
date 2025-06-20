package ru.sbernotify.storage.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationStatus {

    @Id
    private UUID id;
    private String type;
    private String recipient;
    private String subject;
    private String message;
    private LocalDateTime createdAt;
    private boolean delivered;
}
