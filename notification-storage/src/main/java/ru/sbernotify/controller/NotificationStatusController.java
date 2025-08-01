package ru.sbernotify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sbernotify.model.NotificationStatus;
import ru.sbernotify.service.NotificationStatusService;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class NotificationStatusController {

    private final NotificationStatusService service;

    @GetMapping
    public List<NotificationStatus> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public NotificationStatus byId(@PathVariable UUID id) {
        return service.findById(id);
    }
}
