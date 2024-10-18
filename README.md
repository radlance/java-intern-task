 # Задание
 ---
 Написать на Java программу, которая создает таблицу в базе данных, выполняет запрос SQL из таблицы
базы данных и выводит результат на экран.
Для чтения / записи данных можно использовать Spring Boot + Spring Data JPA, (или) Hibernate или
технологию JDBC.
Все SQL запросы в приложении должны быть нативные.
Результат должен выводиться на консоль (GUI не нужен).

 ## Задание 1

 Создать таблицу Employee и наполнить ее данными.
В таблице следующие колонки:
+ ID сотрудника
+ Имя
+ Фамилия
+ Дата рождения
+ Отдел
+ Зарплата

## Задание 2 

Реализовать Сервис
Реализовать класс EmployeeService, у которого будет следующий функционал:

### *Задание 2.1 – Найти пользователя по ID*

Для сервиса EmployeeService необходимо реализовать метод findById для поиска сотрудников по ID в
таблице. При этом необходимо помнить, что переданного в качестве параметра ID может не содержаться
в таблице.

### *Задание 2.2 – Сгруппировать пользователей по именам*

Для сервиса EmployeeService необходимо реализовать метод groupByName, который будет возвращать
список сгруппированных имен сотрудников.

### Задание *2.3 – Поиск между датами*

Для сервиса EmployeeService необходимо реализовать метод findBetween, который будет возвращать
список сотрудников, чьи даты рождения находятся в интервале (пример 1990 и 1992).

--- 

### Подготовка проекта

```yml
src/main/resources/application.yml

spring:
  jpa:
    hibernate:
      ddl-auto: none
    properties:
      hibernate:
        format_sql: true
  datasource:
    # database: postgreSQL
    url: ${DATABASE_URL} # replace with your database url
    username: ${DATABASE_USERNAME} # replace with your database username
    password: ${DATABASE_PASSWORD} # replace with your database user password
  application:
    name: "java-intern-task"
```
