package ru.sbernotify.retry;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.sbernotify.model.NotificationEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class RetryConsumer {

    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    @KafkaListener(
            topics = "notifications.retry",
            groupId = "retry-group",
            containerFactory = "notificationKafkaListenerContainerFactory"
    )
    public void listen(ConsumerRecord<String, NotificationEvent> record) {
        NotificationEvent event = record.value();
        log.info("Повторная обработка уведомления: {}", event);

        try {
            kafkaTemplate.send("notifications", event);
            log.info(" Уведомление успешно переотправлено в notifications");
        } catch (Exception e) {
            log.error(" Ошибка при повторной отправке уведомления: {}", e.getMessage(), e);
        }
    }
}
