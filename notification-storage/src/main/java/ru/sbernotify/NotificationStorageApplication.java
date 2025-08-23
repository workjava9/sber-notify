package ru.sbernotify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class NotificationStorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationStorageApplication.class, args);
    }
}
