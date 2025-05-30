# Budget App in Kotlin

## Описание

Это консольное приложение для управления бюджетом, написанное на Kotlin.  Оно позволяет добавлять элементы бюджета (доходы и расходы), просматривать общий баланс, месячные расходы, средние расходы и расходы по категориям.  Также можно просматривать доходы и расходы за определенный период времени.

## Функциональность

*   **Добавление элементов бюджета:**  Позволяет добавлять записи о доходах и расходах с указанием даты, категории, суммы и описания.

*   **Просмотр общего баланса:**  Отображает текущий баланс на основе всех добавленных элементов бюджета.

*   **Просмотр месячных расходов:**  Показывает общую сумму расходов за указанный месяц.

*   **Просмотр месячных доходов:** Показывает общую сумму доходов за указанный месяц.

*   **Просмотр средних расходов:**  Вычисляет среднюю сумму расходов на основе всех добавленных элементов расходов.

*   **Просмотр расходов по категориям:**  Отображает расходы, сгруппированные по категориям за указанный месяц.

*   **Просмотр доходов/расходов за период:** Позволяет указать начальную и конечную дату и увидеть общую сумму доходов или расходов за этот период.

## Требования

*   [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (версия 8 или выше)

*   [IntelliJ IDEA](https://www.jetbrains.com/idea/) (или другая IDE, поддерживающая Kotlin)

*   [Gradle](https://gradle.org/) (опционально, для сборки проекта)

## Инструкция по запуску

1.  Склонируйте репозиторий: `git clone Codename-Nik/Budget`

2.  Откройте проект в IntelliJ IDEA.

3.  Gradle автоматически загрузит необходимые зависимости. Если этого не произошло, выполните `Gradle -> Refresh All` в IntelliJ IDEA.

4.  Запустите класс `Main.kt`.

## Использование

После запуска приложения вы увидите меню с доступными командами. Следуйте инструкциям на экране, чтобы добавлять элементы бюджета и просматривать аналитику.

## Структура проекта

budget-app/

├── src/

│   ├── main/

│   │   ├── kotlin/

│   │   │   ├── Main.kt           // Точка входа приложения

│   │   │   ├── model/            // Классы данных

│   │   │   │   ├── BudgetItem.kt  // Представление элемента бюджета (доход/расход)

│   │   │   │   ├── Budget.kt      // Представление общего бюджета

│   │   │   ├── service/           // Сервисы для логики приложения

│   │   │   │   ├── BudgetService.kt // Логика работы с бюджетом (добавление, анализ)

│   │   │   ├── ui/               // UI (консольный)

│   │   │   │   ├── ConsoleUI.kt   // UI для консоли

│   ├── test/                     // Тесты

│   │   ├── kotlin/

│   │   │   ├── service/

│   │   │   │   ├── BudgetServiceTest.kt

├── build.gradle.kts          // Файл сборки Gradle

├── README.md                 // Этот файл

## Тестирование

Для запуска тестов выполните `Gradle -> Tasks -> verification -> test` в IntelliJ IDEA.

## Зависимости

*   Kotlin Standard Library

*   JUnit Jupiter (для тестирования)

## Дальнейшее развитие

*   Реализация графического интерфейса (GUI).

*   Поддержка сохранения данных в файл (например, CSV или JSON) для сохранения бюджета между запусками приложения.

*   Добавление более сложных аналитических функций (например, прогнозирование бюджета).

*   Поддержка различных валют.

