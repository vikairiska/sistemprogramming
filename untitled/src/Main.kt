import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import kotlin.math.pow
import kotlin.math.sqrt
// 11. Класс "Магазин"
//Реализуйте класс Product с полями name, price, и quantity. Создайте класс Store, который содержит список продуктов и методы для добавления, удаления и поиска товаров по имени.
//
//12. Интерфейс "Платежная система"
//Создайте интерфейс PaymentSystem с методами pay() и refund(). Реализуйте классы CreditCard и PayPal, которые реализуют этот интерфейс.
//
//13. Генерация уникальных идентификаторов
//Создайте класс UniqueID, который генерирует уникальные идентификаторы для объектов каждого созданного класса. Реализуйте этот функционал через статическое поле и метод.
//
//14. Класс "Точка" и "Прямоугольник"
//Создайте класс Point с координатами x и y. Реализуйте класс Rectangle, который содержит две точки (левая верхняя и правая нижняя). Реализуйте метод для вычисления площади прямоугольника.
//
//15. Комплексные числа
//Создайте класс ComplexNumber с полями для действительной и мнимой частей. Реализуйте методы для сложения, вычитания, умножения и деления комплексных чисел.
data class Product(val name: String, val price: Double, var quantity: Int)

class Store {
    private val products = mutableListOf<Product>()

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun removeProduct(name: String) {
        products.removeIf { it.name == name }
    }

    fun findProduct(name: String): Product? {
        return products.find { it.name == name }
    }
}

interface PaymentSystem {
    fun pay(amount: Double)
    fun refund(amount: Double)
}

internal class CreditCard : PaymentSystem {
    override fun pay(amount: Double) {
        println("Paying $amount using Credit Card")
    }

    override fun refund(amount: Double) {
        println("Refunding $amount using Credit Card")
    }
}

class PayPal : PaymentSystem {
    override fun pay(amount: Double) {
        println("Paying $amount using PayPal")
    }

    override fun refund(amount: Double) {
        println("Refunding $amount using PayPal")
    }
}

class UniqueID {
    companion object {
        private var counter = 0

        fun getUniqueID(): Int {
            return ++counter
        }
    }
}

data class Point(val x: Int, val y: Int)

class Rectangle(private val topLeft: Point, private val bottomRight: Point) {
    fun calculateArea(): Int {
        val width = bottomRight.x - topLeft.x
        val height = topLeft.y - bottomRight.y
        return width * height
    }
}

data class ComplexNumber(val real: Double, val imaginary: Double) {
    operator fun plus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real + other.real, this.imaginary + other.imaginary)
    }

    operator fun minus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real - other.real, this.imaginary - other.imaginary)
    }

    operator fun times(other: ComplexNumber): ComplexNumber {
        val realPart = this.real * other.real - this.imaginary * other.imaginary
        val imaginaryPart = this.real * other.imaginary + this.imaginary * other.real
        return ComplexNumber(realPart, imaginaryPart)
    }

    operator fun div(other: ComplexNumber): ComplexNumber {
        val denominator = other.real * other.real + other.imaginary * other.imaginary
        val realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator
        val imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator
        return ComplexNumber(realPart, imaginaryPart)
    }
}

fun main() {
    // Пример использования классов
    val store = Store()
    val product1 = Product("Apple", 1.0, 10)
    val product2 = Product("Banana", 0.5, 20)
    store.addProduct(product1)
    store.addProduct(product2)
    println(store.findProduct("Apple"))
    store.removeProduct("Banana")
    println(store.findProduct("Banana"))

    val creditCard = CreditCard()
    val payPal = PayPal()
    creditCard.pay(100.0)
    payPal.refund(50.0)

    println(UniqueID.getUniqueID())
    println(UniqueID.getUniqueID())

    val topLeft = Point(0, 10)
    val bottomRight = Point(10, 0)
    val rectangle = Rectangle(topLeft, bottomRight)
    println("Rectangle Area: ${rectangle.calculateArea()}")

    val complex1 = ComplexNumber(1.0, 2.0)
    val complex2 = ComplexNumber(3.0, 4.0)
    val sum = complex1 + complex2
    val difference = complex1 - complex2
    val product = complex1 * complex2
    val quotient = complex1 / complex2
    println("Sum: $sum")
    println("Difference: $difference")
    println("Product: $product")
    println("Quotient: $quotient")
}

// 1. Функция для нахождения максимума
fun findMax(a: Int, b: Int): Int {
    if (a == b) {
        throw Exception("Числа равны")
    }
    return if (a > b) a else b
}

// 2. Калькулятор деления
fun divide(a: Int, b: Int): Double {
    if (b == 0) {
        throw ArithmeticException("Деление на ноль недопустимо")
    }
    return a.toDouble() / b
}

// 3. Конвертер строк в числа
fun stringToInt(s: String): Int {
    return s.toIntOrNull() ?: throw NumberFormatException("Неверный формат строки")
}

// 4. Проверка возраста
fun checkAge(age: Int) {
    if (age < 0 || age > 150) {
        throw IllegalArgumentException("Недопустимый возраст")
    }
}

// 5. Нахождение корня
fun sqrt(number: Int): Double {
    if (number < 0) {
        throw IllegalArgumentException("Недопустимое число для извлечения корня")
    }
    return sqrt(number.toDouble())
}

// 6. Факториал
fun factorial(number: Int): Int {
    if (number < 0) {
        throw IllegalArgumentException("Недопустимое число для вычисления факториала")
    }
    var result = 1
    for (i in 1..number) {
        result *= i
    }
    return result
}

// 7. Проверка массива на нули
fun checkArrayForZeros(array: IntArray) {
    if (array.contains(0)) {
        throw Exception("Массив содержит нули")
    }
}

// 8. Калькулятор возведения в степень
fun power(base: Int, exponent: Int): Int {
    if (exponent < 0) {
        throw IllegalArgumentException("Недопустимая степень")
    }
    return base.toDouble().pow(exponent.toDouble()).toInt()
}

// 9. Обрезка строки
fun truncateString(s: String, length: Int): String {
    if (length > s.length) {
        throw Exception("Длина больше длины строки")
    }
    return s.substring(0, length)
}

// 10. Поиск элемента в массиве
fun findElement(array: IntArray, element: Int): Int {
    if (!array.contains(element)) {
        throw Exception("Элемент не найден")
    }
    return element
}

// 11. Конвертация в двоичную систему
fun toBinary(number: Int): String {
    if (number < 0) {
        throw IllegalArgumentException("Недопустимое число для конвертации")
    }
    return number.toString(2)
}

// 12. Проверка делимости
fun isDivisible(a: Int, b: Int): Boolean {
    if (b == 0) {
        throw ArithmeticException("Деление на ноль недопустимо")
    }
    return a % b == 0
}

// 13. Чтение элемента списка
fun getListElement(list: List<Int>, index: Int): Int {
    if (index < 0 || index >= list.size) {
        throw IndexOutOfBoundsException("Индекс выходит за пределы списка")
    }
    return list[index]
}

// 14. Парольная проверка
fun checkPassword(password: String) {
    if (password.length < 8) {
        throw Exception("Слабый пароль")
    }
}

// 15. Проверка даты
fun isValidDate(date: String): Boolean {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return try {
        LocalDate.parse(date, formatter)
        true
    } catch (e: DateTimeParseException) {
        throw IllegalArgumentException("Неверный формат даты: $date")
    }
}

// 16. Конкатенация строк
fun concatStrings(s1: String?, s2: String?): String {
    if (s1 == null || s2 == null) {
        throw NullPointerException("Одна из строк равна null")
    }
    return s1 + s2
}

// 17. Остаток от деления
fun modulus(a: Int, b: Int): Int {
    if (b == 0) {
        throw IllegalArgumentException("Деление на ноль недопустимо")
    }
    return a % b
}

// 18. Квадратный корень
fun squareRoot(number: Int): Double {
    if (number < 0) {
        throw IllegalArgumentException("Недопустимое число для извлечения корня")
    }
    return sqrt(number.toDouble())
}

// 19. Конвертер температуры
fun celsiusToFahrenheit(celsius: Double): Double {
    if (celsius < -273.15) {
        throw IllegalArgumentException("Температура ниже абсолютного нуля")
    }
    return (celsius * 9 / 5) + 32
}

// 20. Проверка строки на пустоту
fun checkEmptyString(s: String?) {
    if (s.isNullOrEmpty()) {
        throw Exception("Строка пустая или null")
    }
}