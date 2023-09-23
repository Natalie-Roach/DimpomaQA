# Отчёт по итогам автоматизации 
## Запланировано и реализовано:
Все запланированные сценарии тестирования (28 шт.) были реализованы в автоматические тесты для проверки покупки тура в Марракеш по дебетовой и кредитной карте.

## Выявленные риски:
1. сложность в нахождении локаторов "data-test-id" для тестирования на странице в DEVTools;
2. сложность с запуском jar-файла для двух БД;
3. сложность с несовместимостью ChromeDriver c браузером Google Chrome - возможна работа с версией 114, в то время как браузер обновлен до версии 117;
4. необходимость "снести" браузер Google Chrome и поставить версию с открытым исходным кодом для разработчиков - Chromium версии 114;
5. сложность с генерацией отчета в Allure (генерировался пустой отчет) - необходимость обновления плагинов до последних версий.

## Затраченное время на реализацию дипломной работы:
- Ожидалось затратить ~ 110 часов
- Получилось затратить ~ 150 часов с учетом появления рисков