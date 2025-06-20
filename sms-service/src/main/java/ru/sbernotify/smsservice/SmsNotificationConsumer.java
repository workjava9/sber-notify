package ru.sbernotify.smsservice;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.sbernotify.model.NotificationEvent;

@Slf4j
@Service
public class SmsNotificationConsumer {

    @KafkaListener(
            topics = "notifications",
            groupId = "sms-service-group",
            containerFactory = "notificationKafkaListenerContainerFactory"
    )
    public void listen(ConsumerRecord<String, NotificationEvent> record) {
        NotificationEvent event = record.value();
        if (event.getType().name().equalsIgnoreCase("SMS")) {
            log.info("🔔 Обработка SMS-SERVICE уведомления: {}", event);
            sendSms(event);
        }
    }

    private void sendSms(NotificationEvent event) {
        log.info("📱 SMS отправлен через mock API → to='{}' | text='{}'",
                event.getRecipient(), event.getMessage());

    }
}
