package ru.sbernotify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbernotify.model.NotificationEvent;
import ru.sbernotify.service.NotificationProducer;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationProducer producer;

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestBody NotificationEvent event) {
        event.setId(UUID.randomUUID());
        event.setCreatedAt(LocalDateTime.now());
        producer.send(event);
        return ResponseEntity.ok("Notification sent");
    }
}
