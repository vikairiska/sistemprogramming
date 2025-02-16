import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Random;
import java.text.SimpleDateFormat;

public class AllTasks {

    // Задача 1: Основы LocalDate и LocalTime
    public static void task1() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(currentDate.atTime(currentTime)));
    }

    // Задача 2: Сравнение дат
    public static String compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            return "Первая дата раньше второй.";
        } else if (date1.isAfter(date2)) {
            return "Вторая дата раньше первой.";
        } else {
            return "Даты равны.";
        }
    }

    // Задача 3: Сколько дней до Нового года?
    public static long daysUntilNewYear() {
        LocalDate today = LocalDate.now();
        LocalDate newYear = today.withDayOfYear(1).plusYears(1);

        return newYear.toEpochDay() - today.toEpochDay();
    }

    // Задача 4: Проверка високосного года
    public static boolean isLeapYear(int year) {
        Year y = Year.of(year);
        return y.isLeap();
    }

    // Задача 5: Подсчет выходных за месяц
    public static int countWeekendsInMonth(int month, int year) {
        LocalDate firstDay = LocalDate.of(year, month, 1);
        LocalDate lastDay = firstDay.with(TemporalAdjusters.lastDayOfMonth());

        int weekendsCount = 0;

        for (LocalDate date = firstDay; !date.isAfter(lastDay); date = date.plusDays(1)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();

            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                weekendsCount++;
            }
        }

        return weekendsCount;
    }

    // Задача 6: Расчет времени выполнения метода
    public static void measureExecutionTime(Runnable task) {
        Instant start = Instant.now();
        task.run();
        Instant end = Instant.now();

        long duration = end.toEpochMilli() - start.toEpochMilli();
        System.out.printf("Время выполнения: %d мс\n", duration);
    }

    // Задача 7: Форматирование и парсинг даты
    public static void parseAndFormatDate(String inputDate) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate parsedDate = LocalDate.parse(inputDate, inputFormatter);
        LocalDate updatedDate = parsedDate.plusDays(10);

        String formattedDate = updatedDate.format(outputFormatter);

        System.out.println(formattedDate);
    }

    // Задача 8: Конвертация между часовыми поясами
    public static void convertTimeZone(ZonedDateTime utcDateTime, String targetTimeZoneId) {
        ZonedDateTime targetDateTime = utcDateTime.withZoneSameInstant(ZoneId.of(targetTimeZoneId));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

        System.out.println(targetDateTime.format(formatter));
    }

    // Задача 9: Вычисление возраста по дате рождения
    public static int calculateAge(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        Period agePeriod = Period.between(birthDate, today);

        return agePeriod.getYears();
    }

    // Задача 10: Создание календаря на месяц
    public static void printCalendarForMonth(Month month, int year) {
        LocalDate firstDay = LocalDate.of(year, month, 1);
        LocalDate lastDay = firstDay.with(TemporalAdjusters.lastDayOfMonth());

        System.out.printf("%s %d%n", month, year);
        System.out.println("Пн Вт Ср Чт Пт Сб Вс");

        int offset = firstDay.getDayOfWeek().getValue() - 1;
        for (int i = 0; i < offset; i++) {
            System.out.print("   ");
        }

        for (LocalDate date = firstDay; !date.isAfter(lastDay); date = date.plusDays(1)) {
            String dayStr = String.format("%2d ", date.getDayOfMonth());
            System.out.print(dayStr);

            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
            }
        }

        System.out.println(); // Завершаем вывод последней строки
    }

    // Задача 11: Генерация случайной даты в диапазоне
    public static LocalDate generateRandomDateBetween(LocalDate startDate, LocalDate endDate) {
        Random random = new Random();

        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomDay = startEpochDay + random.nextLong(endEpochDay - startEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    // Задача 12: Расчет времени до заданной даты
    public static void timeLeftToEvent(LocalDateTime eventDateTime) {
        LocalDateTime now = LocalDateTime.now();

        Duration duration = Duration.between(now, eventDateTime);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.printf("До события осталось: %d:%02d:%02d\n", hours, minutes, seconds);
    }

    // Задача 13: Вычисление количества рабочих часов
    public static double calculateWorkingHours(LocalDateTime start, LocalDateTime end) {
        double totalHours = ChronoUnit.HOURS.between(start, end);

        while (!start.isAfter(end)) {
            if (start.getDayOfWeek() == DayOfWeek.SATURDAY || start.getDayOfWeek() == DayOfWeek.SUNDAY) {
                totalHours -= 24;
            }
            start = start.plusDays(1);
        }

        return totalHours;
    }

    // Задача 14: Конвертация даты в строку с учетом локали
    public static String formatDateWithLocale(java.util.Date date, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", locale);
        return sdf.format(date);
    }

    // Задача 15: Определение дня недели по дате
    public static String getDayOfWeekName(LocalDate date) {
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"));
    }

    public static void main(String[] args) {
        // Задача 1
        task1();

        // Задача 2
        LocalDate date1 = LocalDate.parse("2023-01-05");
        LocalDate date2 = LocalDate.parse("2023-02-20");
        System.out.println(compareDates(date1, date2));

        // Задача 3
        System.out.println(daysUntilNewYear());

        // Задача 4
        int year = 2020;
        System.out.println(isLeapYear(year));

        // Задача 5
        int month = 10;
        int year5 = 2023;
        System.out.println(countWeekendsInMonth(month, year5));

        // Задача 6
        Runnable loopTask = () -> {
            for (int i = 0; i < 1000000; i++) {
                Math.sqrt(i);
            }
        };
        measureExecutionTime(loopTask);

        // Задача 7
        String inputDate = "25-12-2023";
        parseAndFormatDate(inputDate);

        // Задача 8
        ZonedDateTime utcDateTime = ZonedDateTime.parse("2023-10-30T12:34:56Z");
        String targetTimeZoneId = "Europe/Moscow";
        convertTimeZone(utcDateTime, targetTimeZoneId);

        // Задача 9
        LocalDate birthDate = LocalDate.parse("1990-03-21");
        int age = calculateAge(birthDate);
        System.out.println(age);

        // Задача 10
        Month month10 = Month.OCTOBER;
        int year10 = 2023;
        printCalendarForMonth(month10, year10);

        // Задача 11
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        LocalDate randomDate = generateRandomDateBetween(startDate, endDate);
        System.out.println(randomDate);

        // Задача 12
        LocalDateTime eventDateTime = LocalDateTime.of(2023, 12, 24, 18, 30);
        timeLeftToEvent(eventDateTime);

        // Задача 13
        LocalDateTime start13 = LocalDateTime.of(2023, 10, 23, 9, 0);
        LocalDateTime end13 = LocalDateTime.of(2023, 10, 28, 17, 0);
        double workingHours = calculateWorkingHours(start13, end13);
        System.out.println(workingHours);

        // Задача 14
        java.util.Date date = new java.util.Date();
        Locale localeRu = new Locale("ru", "RU");
        Locale localeEn = new Locale("en", "US");
        System.out.println(formatDateWithLocale(date, localeRu)); // На русском
        System.out.println(formatDateWithLocale(date, localeEn)); // На английском

        // Задача 15
        LocalDate date15 = LocalDate.of(2023, 10, 29);
        String dayOfWeekName = getDayOfWeekName(date15);
        System.out.println(dayOfWeekName);
    }
}