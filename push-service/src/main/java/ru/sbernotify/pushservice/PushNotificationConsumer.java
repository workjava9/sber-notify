package ru.sbernotify.pushservice;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.sbernotify.model.NotificationEvent;

@Slf4j
@Service
public class PushNotificationConsumer {

    @KafkaListener(
            topics = "notifications",
            groupId = "push-service-group",
            containerFactory = "notificationKafkaListenerContainerFactory"
    )
    public void listen(ConsumerRecord<String, NotificationEvent> record) {
        NotificationEvent event = record.value();

        if (event.getType().name().equalsIgnoreCase("PUSH")) {
            log.info("🔔 Обработка PUSH-SERVICE уведомления: {}", event);
            sendWebPush(event);
        }
    }

    private void sendWebPush(NotificationEvent event) {
        log.info("WebPush отправлен через mock API → to='{}' | subject='{}' | message='{}'",
                event.getRecipient(), event.getSubject(), event.getMessage());

    }
}
