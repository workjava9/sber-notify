package ru.sbernotify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbernotify.model.NotificationStatus;
import ru.sbernotify.repository.NotificationStatusRepository;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationStatusService {

    private final NotificationStatusRepository repository;

    public void save(NotificationStatus status) {
        repository.save(status);
    }

    public List<NotificationStatus> findAll() {
        return repository.findAll();
    }

    public NotificationStatus findById(UUID id) {
        return repository.findById(id).orElse(null);
    }
}
