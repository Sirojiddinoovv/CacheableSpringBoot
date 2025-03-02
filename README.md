# Redis Cache Demo (Spring Boot)

## Описание
Этот проект демонстрирует использование Redis для кэширования в Spring Boot. 
Кэширование помогает ускорить работу приложения, снижая нагрузку на базу данных и повышая производительность.

## Стек технологий
- **Java 17+** (Spring Boot)
- **Redis** (Spring Data Redis, Lettuce)
- **Maven** (для управления зависимостями)
- **Docker** (опционально, для развёртывания Redis)

## Структура проекта
```
RedisCacheDemo/
│── src/main/java/uz/nodir/rediscachedemo/
│   ├── RedisCacheDemoApplication.java   # Главный класс Spring Boot
│   ├── configuration/RedisConfig.java   # Конфигурация Redis
│   ├── controller/StatusController.java  # REST API
│   ├── entity/
│   │   ├── BaseEntity.java
│   │   ├── Status.java
│   ├── repository/StatusRepository.java  # Spring Data Repository
│   ├── service/StatusService.java        # Бизнес-логика
│── pom.xml  # Maven конфигурация
│── Dockerfile  # (если присутствует) контейнеризация
```

## Установка и запуск

### 1. Запуск Redis
Если Redis не установлен локально, можно запустить его через Docker:
```sh
docker run --name redis-cache -p 6379:6379 -d redis
```

### 2. Настройка приложения
В файле `application.yml` укажите параметры подключения к Redis:
```yaml
spring:
  redis:
    host: localhost
    port: 6379
```

### 3. Сборка и запуск
Запустите приложение с помощью Maven:
```sh
mvn clean install
mvn spring-boot:run
```

## Использование API
### Доступные эндпоинты
- **POST** `/api/v1/status` – Создание нового статуса
- **PUT** `/api/v1/status/{id}` – Обновление статуса по ID
- **GET** `/api/v1/status` – Получение списка статусов
- **GET** `/api/v1/status/{id}` – Получение статуса по ID
- **DELETE** `/api/v1/status/{id}` – Удаление статуса по ID

## Лицензия
Этот проект распространяется под лицензией MIT.
