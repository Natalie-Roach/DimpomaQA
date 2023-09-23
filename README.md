# Процедура запуска автотестов:

## Шаг 1 - запуск контейнеров:
1. Открываем скачанное заранее **desktop-приложение Docker**
2. Запускаем контейнеры с базами данных MySQL и PostgreSQL и эмулятором банковских сервисов Node.js через терминал IDEA с помощью команды **docker-compose up**

## Шаг 2 - запуск SUT:
- для MySQL в терминале IDEA используем команду: **java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar**
- для PostgreSQL в терминале IDEA используем команду: **java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar**

## Приложение запускается на порту 8080
URL : http://localhost:8080/

## Шаг 3 - запуск тестов:
- для MySQL в терминале IDEA используем команду: **./gradlew clean test "-Durl=jdbc:mysql://localhost:3306/app"**
- для PostgreSQL в терминале IDEA используем команду: **./gradlew clean test "-Durl=jdbc:postgresql://localhost:5432/app"**

## Шаг 4 - запуск репортинга Allure:
Запускаем репортниг Allure командой **./gradlew allureServe** для открытия отчета сразу в браузере

## Шаг 5 - завершение работы:
Вводим в терминал IDEA команду **Ctrl+C**

## Шаг 6 - остановка контейнеров:
Для остановки работы контейнеров вводим в терминал IDEA команду **docker-compose down**

