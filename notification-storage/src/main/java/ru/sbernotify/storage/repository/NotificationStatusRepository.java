package ru.sbernotify.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbernotify.storage.model.NotificationStatus;
import java.util.UUID;

public interface NotificationStatusRepository extends JpaRepository<NotificationStatus, UUID> {
}
