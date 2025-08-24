# SberNotify — Микросервисная система доставки уведомлений

**SberNotify** — распределённая система обработки и доставки уведомлений (Email, SMS, Push), построенная на базе **Spring Boot** и **Apache Kafka**. Проект реализует микросервисную архитектуру, ориентированную на отказоустойчивость, масштабируемость и простоту интеграции.



## Цель проекта

Создать production-ready решение для маршрутизации и доставки сообщений с поддержкой:
- асинхронной обработки через Kafka
- повторной доставки через DLQ
- расширяемости без изменения основного кода
- мониторинга и хранения статусов сообщений



## Архитектура

Проект построен по принципам **Single Responsibility**, **SOLID** и **Clean Architecture**.

**Сервисы:**
- `api-gateway` — REST-интерфейс + Kafka producer
- `email-service` — consumer Email-уведомлений (SMTP)
- `sms-service` — consumer SMS-уведомлений (mock)
- `push-service` — consumer Push-уведомлений (WebPush API mock)
- `retry-service` — повторная доставка из Kafka DLQ
- `notification-storage` — хранение статусов в PostgresSQL (Spring Data Redis)
- `notification-core` — DTO, enum's, общие модели
  
## Demo: Kafka Lab

В дополнение к основным микросервисам, проект сопровождается учебной песочницей **Kafka Lab** — демонстрацией продюсера и консьюмера на Spring Boot + Kafka + Prometheus.  

Kafka Lab используется для иллюстрации работы **event-driven архитектуры**:  
- `user-events-producer` публикует события (`UserEvent`) в Kafka-топик  
- `analytics-consumer` принимает события и собирает метрики через Micrometer  

Подробнее можно посмотреть в репозитории [Kafka Lab](https://github.com/workjava9/kafka-lab).

## Технологический стек

Язык программирования: Java 17

1. Бэкенд: Spring Boot, Spring Kafka, Spring JPA
2. База данных: PostgreSQL
3. Система обмена сообщениями: Apache Kafka с поддержкой DLQ (Dead Letter Queue)
4. Email-уведомления: Spring Mail с использованием SMTP
5. Push-уведомления: эмуляция отправки через mock WebPush API
6. Тестирование: JUnit 5, Spring Boot Test, Mockito
7. Контейнеризация: Docker и docker-compose
8. Мониторинг и метрики: Spring Boot Actuator, готов к интеграции с Prometheus
9. Кеширование: Spring Data Redis для ускорения доступа к часто запрашиваемым данным
 10. Сборка проекта: Gradle с использованием Kotlin DSL

## Старт

1. **Запуск зависимостей (Kafka, PostgreSQL):**

```bash
docker compose up -d
```
Внимание: данный проект — учебный pet-проект, не является официальным продуктом Сбербанка. Название выбрано с уважением к корпоративным стандартам качества и архитектуры.

 
 
 
 
