package ru.sbernotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbernotify.model.NotificationStatus;

import java.util.List;
import java.util.UUID;

public interface NotificationStatusRepository extends JpaRepository<NotificationStatus, UUID> {

    List<NotificationStatus> findByRecipientAndType(String recipient, String type);
}
