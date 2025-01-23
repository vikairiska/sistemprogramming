import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задача 1: Четное или нечетное число
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();
        System.out.println(number % 2 == 0 ? "Четное число." : "Нечетное число.");

        // Задача 2: Минимальное из трех чисел
        System.out.print("Введите три целых числа: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int min = Math.min(a, Math.min(b, c));
        System.out.println("Минимальное число: " + min);

        // Задача 3: Таблица умножения
        System.out.println("Таблица умножения на 5:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 * " + i + " = " + (5 * i));
        }

        // Задача 4: Сумма чисел от 1 до N
        System.out.print("Введите целое число N: ");
        int N = scanner.nextInt();
        int sum = (N * (N + 1)) / 2;
        System.out.println("Сумма чисел от 1 до " + N + ": " + sum);

        // Задача 5: Число Фибоначчи
        System.out.print("Введите целое число N: ");
        N = scanner.nextInt();
        int aFib = 0, bFib = 1;
        System.out.print("Первые " + N + " чисел Фибоначчи: ");
        for (int i = 1; i <= N; i++) {
            System.out.print(aFib + " ");
            int nextFib = aFib + bFib;
            aFib = bFib;
            bFib = nextFib;
        }
        System.out.println();

        // Задача 6: Проверка простого числа
        System.out.print("Введите целое число: ");
        number = scanner.nextInt();
        boolean isPrime = number >= 2;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? number + " - простое число." : number + " - не простое число.");

        // Задача 7: Обратный порядок чисел
        System.out.print("Введите целое число N: ");
        N = scanner.nextInt();
        System.out.print("Числа от " + N + " до 1: ");
        for (int i = N; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Задача 8: Сумма четных чисел
        System.out.print("Введите два целых числа A и B: ");
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        sum = 0;
        for (int i = A; i <= B; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("Сумма четных чисел от " + A + " до " + B + ": " + sum);

        // Задача 9: Реверс строки
        System.out.print("Введите строку: ");
        scanner.nextLine();
        String inputString = scanner.nextLine();
        String reversedString = new StringBuilder(inputString).reverse().toString();
        System.out.println("Обратная строка: " + reversedString);

        // Задача 10: Количество цифр в числе
        System.out.print("Введите целое число: ");
        number = scanner.nextInt();
        int digitCount = String.valueOf(Math.abs(number)).length();
        System.out.println("Количество цифр в числе: " + digitCount);

        // Задача 11: Факториал числа
        System.out.print("Введите целое число N: ");
        N = scanner.nextInt();
        long factorial = 1;
        for (int i = 1; i <= N; i++) {
            factorial *= i;
        }
        System.out.println("Факториал " + N + ": " + factorial);

        // Задача 12: Сумма цифр числа
        System.out.print("Введите целое число: ");
        number = scanner.nextInt();
        int sumOfDigits = 0;
        while (number != 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }
        System.out.println("Сумма цифр числа: " + sumOfDigits);

        // Задача 13: Палиндром
        System.out.print("Введите строку: ");
        scanner.nextLine();
        inputString = scanner.nextLine();
        String normalizedString = inputString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Убираем пробелы и специальные символы
        String reversedNormalizedString = new StringBuilder(normalizedString).reverse().toString();
        System.out.println(normalizedString.equals(reversedNormalizedString) ? "Строка является палиндромом." : "Строка не является палиндромом.");

        // Задача 14: Найти максимальное число в массиве
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int maxNumber = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
        }
        System.out.println("Максимальное число в массиве: " + maxNumber);

        // Задача 15: Сумма всех элементов массива
        System.out.print("Введите размер массива: ");
        size = scanner.nextInt();
        array = new int[size];
        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int sumOfArray = 0;
        for (int num : array) {
            sumOfArray += num;
        }
        System.out.println("Сумма всех элементов массива: " + sumOfArray);

        // Задача 16: Количество положительных и отрицательных чисел
        System.out.print("Введите размер массива: ");
        size = scanner.nextInt();
        array = new int[size];
        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int positiveCount = 0;
        int negativeCount = 0;
        for (int num : array) {
            if (num > 0) positiveCount++;
            else if (num < 0) negativeCount++;
        }
        System.out.println("Количество положительных чисел: " + positiveCount);
        System.out.println("Количество отрицательных чисел: " + negativeCount);

        // Задача 17: Простые числа в диапазоне
        System.out.print("Введите два целых числа A и B: ");
        A = scanner.nextInt();
        B = scanner.nextInt();
        System.out.print("Простые числа в диапазоне от " + A + " до " + B + ": ");
        for (int i = A; i <= B; i++) {
            if (i < 2) continue;
            isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // Задача 18: Подсчет гласных и согласных в строке
        System.out.print("Введите строку: ");
        inputString = scanner.nextLine();
        int vowelCount = 0;
        int consonantCount = 0;
        for (char ch : inputString.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiouAEIOU".indexOf(ch) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        System.out.println("Количество гласных: " + vowelCount);
        System.out.println("Количество согласных: " + consonantCount);

        // Задача 19: Перестановка слов в строке
        System.out.print("Введите строку: ");
        inputString = scanner.nextLine();
        String[] words = inputString.split(" ");
        StringBuilder reversedWords = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedWords.append(words[i]).append(" ");
        }
        System.out.println("Слова в обратном порядке: " + reversedWords.toString().trim());

        // Задача 20: Число Армстронга
        System.out.print("Введите целое число: ");
        number = scanner.nextInt();
        int originalNumber = number;
        int digitsCount = String.valueOf(number).length();
        int armstrongSum = 0;
        while (number != 0) {
            int digit = number % 10;
            armstrongSum += (int) Math.pow(digit, digitsCount);
            number /= 10;
        }
        System.out.println(armstrongSum == originalNumber ? originalNumber + " - число Армстронга." : originalNumber + " - не число Армстронга.");

        scanner.close();
    }
}