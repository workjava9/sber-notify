package ru.sbernotify.email;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.sbernotify.model.NotificationEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailNotificationConsumer {

    private final JavaMailSender mailSender;

    @KafkaListener(topics = "notifications", groupId = "email-group", containerFactory = "notificationKafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, NotificationEvent> record) {
        NotificationEvent event = record.value();
        if (event.getType().name().equalsIgnoreCase("EMAIL")) {
            log.info("📧 Обработка email уведомления: {}", event);
            sendEmail(event);
        }
    }

    private void sendEmail(NotificationEvent event) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(event.getRecipient());
            message.setSubject(event.getSubject());
            message.setText(event.getMessage());
            message.setFrom("your_email@gmail.com");

            mailSender.send(message);
            log.info("Email отправлен на {}", event.getRecipient());
        } catch (Exception e) {
            log.error("Ошибка при отправке email: {}", e.getMessage(), e);
        }
    }
}
