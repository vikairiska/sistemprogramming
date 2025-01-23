// 1. Класс "Человек"
class Person {
  String name;
  int age;
  String gender;

  Person(this.name, this.age, this.gender);

  void displayInfo() {
    print('Name: $name, Age: $age, Gender: $gender');
  }

  void increaseAge() {
    age++;
  }

  void changeName(String newName) {
    name = newName;
  }

  void changeGender(String newGender) {
    gender = newGender;
  }
}

// 2. Наследование: Класс "Работник" и "Менеджер"
class Worker extends Person {
  double salary;

  Worker(String name, int age, String gender, this.salary)
      : super(name, age, gender);
}

class Manager extends Worker {
  List<Worker> subordinates;

  Manager(String name, int age, String gender, double salary, this.subordinates)
      : super(name, age, gender, salary);
}

// 3. Полиморфизм: Животные
abstract class Animal {
  void makeSound();
}

class Dog implements Animal {
  @override
  void makeSound() {
    print('Woof!');
  }
}

class Cat implements Animal {
  @override
  void makeSound() {
    print('Meow!');
  }
}

class Cow implements Animal {
  @override
  void makeSound() {
    print('Moo!');
  }
}

// 4. Абстрактный класс "Транспорт"
abstract class Transport {
  void move();
}

class Car extends Transport {
  @override
  void move() {
    print('Car is driving.');
  }
}

class Bike extends Transport {
  @override
  void move() {
    print('Bike is riding.');
  }
}

// 5. Класс "Книга" и "Библиотека"
class Book {
  String title;
  String author;
  int year;

  Book(this.title, this.author, this.year);
}

class Library {
  List<Book> books = [];

  void addBook(Book book) {
    books.add(book);
  }

  List<Book> findByAuthor(String author) {
    return books.where((book) => book.author == author).toList();
  }

  List<Book> findByYear(int year) {
    return books.where((book) => book.year == year).toList();
  }
}

void main() {
  // Пример использования классов
  Person person = Person('Alice', 30, 'Female');
  person.displayInfo();
  person.increaseAge();
  person.changeName('Bob');
  person.changeGender("Male");
  person.displayInfo();

  Worker worker = Worker('Charlie', 25, 'Male', 50000);
  Manager manager = Manager('Dave', 40, 'Male', 80000, [worker]);
  print('Manager: ${manager.name}, Salary: ${manager.salary}');

  List<Animal> animals = [Dog(), Cat(), Cow()];
  for (var animal in animals) {
    animal.makeSound();
  }

  Car car = Car();
  Bike bike = Bike();
  car.move();
  bike.move();

  Library library = Library();
  library.addBook(Book('1984', 'George Orwell', 1949));
  library.addBook(Book('To Kill a Mockingbird', 'Harper Lee', 1960));
  print(library.findByAuthor('George Orwell'));
  print(library.findByYear(1960));
}
// // 6. Инкапсуляция: Банк
// class BankAccount {
//   String _accountNumber;
//   double _balance;

//   BankAccount(this._accountNumber, this._balance);

//   void deposit(double amount) {
//     _balance += amount;
//   }

//   void withdraw(double amount) {
//     if (amount <= _balance) {
//       _balance -= amount;
//     } else {
//       print('Insufficient funds.');
//     }
//   }

//   double getBalance() {
//     return _balance;
//   }

//   String getAccountNumber() {
//     return _accountNumber;
//   }
// }

// // 7. Счетчик объектов
// class Counter {
//   static int count = 0;

//   Counter() {
//     count++;
//   }

//   static int getCount() {
//     return count;
//   }
// }

// // 8. Площадь фигур
// abstract class Shape {
//   double getArea();
// }

// class Circle extends Shape {
//   double radius;

//   Circle(this.radius);

//   @override
//   double getArea() {
//     return 3.14 * radius * radius;
//   }
// }

// class Rectangle extends Shape {
//   double width;
//   double height;

//   Rectangle(this.width, this.height);

//   @override
//   double getArea() {
//     return width * height;
//   }
// }

// // 9. Наследование: Животные и их движения
// class Animal {
//   void move() {
//     print('Animal is moving.');
//   }
// }

// class Fish extends Animal {
//   @override
//   void move() {
//     print('Fish is swimming.');
//   }
// }

// class Bird extends Animal {
//   @override
//   void move() {
//     print('Bird is flying.');
//   }
// }

// class Dog extends Animal {
//   @override
//   void move() {
//     print('Dog is running.');
//   }
// }

// // 10. Работа с коллекциями: Университет
// class Student {
//   String name;
//   String group;
//   double grade;

//   Student(this.name, this.group, this.grade);
// }

// class University {
//   List<Student> students = [];

//   void addStudent(Student student) {
//     students.add(student);
//   }

//   void sortByName() {
//     students.sort((a, b) => a.name.compareTo(b.name));
//   }

//   List<Student> filterByGrade(double minGrade) {
//     return students.where((student) => student.grade >= minGrade).toList();
//   }
// }

// void main() {
//   // Пример использования классов
//   BankAccount account = BankAccount('123456', 1000);
//   account.deposit(500);
//   account.withdraw(200);
//   print('Account Number: ${account.getAccountNumber()}, Balance: ${account.getBalance()}');

//   Counter counter1 = Counter();
//   Counter counter2 = Counter();
//   print('Total Counters: ${Counter.getCount()}');

//   Shape circle = Circle(5);
//   Shape rectangle = Rectangle(4, 6);
//   print('Circle Area: ${circle.getArea()}');
//   print('Rectangle Area: ${rectangle.getArea()}');

//   Fish fish = Fish();
//   Bird bird = Bird();
//   Dog dog = Dog();
//   fish.move();
//   bird.move();
//   dog.move();

//   University university = University();
//   university.addStudent(Student('Eve', 'Group A', 85));
//   university.addStudent(Student('Frank', 'Group B', 90));
//   university.sortByName();
//   print(university.filterByGrade(85));
// }
// // 16. Перегрузка операторов: Матрица
// class Matrix {
//   List<List<double>> data;

//   Matrix(this.data);

//   Matrix operator +(Matrix other) {
//     List<List<double>> result = [];
//     for (int i = 0; i < data.length; i++) {
//       List<double> row = [];
//       for (int j = 0; j < data[i].length; j++) {
//         row.add(data[i][j] + other.data[i][j]);
//       }
//       result.add(row);
//     }
//     return Matrix(result);
//   }

//   Matrix operator *(Matrix other) {
//     List<List<double>> result = List.generate(data.length, (_) => List.generate(other.data[0].length, (_) => 0.0));
//     for (int i = 0; i < data.length; i++) {
//       for (int j = 0; j < other.data[0].length; j++) {
//         for (int k = 0; k < data[0].length; k++) {
//           result[i][j] += data[i][k] * other.data[k][j];
//         }
//       }
//     }
//     return Matrix(result);
//   }
// }

// // 17. Создание игры с использованием ООП
// class Player {
//   String name;
//   int health;
//   String symbol;

//   Player(this.name, this.health, this.symbol);

//   void attack(Enemy enemy) {
//     enemy.takeDamage(10);
//   }
// }

// class Enemy {
//   String name;
//   int health;

//   Enemy(this.name, this.health);

//   void takeDamage(int damage) {
//     health -= damage;
//     if (health <= 0) {
//       print('$name is defeated!');
//     }
//   }
// }

// class Weapon {
//   String name;
//   int damage;

//   Weapon(this.name, this.damage);

//   void use(Player player, Enemy enemy) {
//     enemy.takeDamage(damage);
//   }
// }

// // 18. Автоматизированная система заказов
// class Product {
//   String name;
//   double price;
//   int quantity;

//   Product(this.name, this.price, this.quantity);
// }

// class Order {
//   List<Product> products = [];

//   void addProduct(Product product) {
//     products.add(product);
//   }

//   double getTotal() {
//     return products.fold(0, (sum, product) => sum + product.price * product.quantity);
//   }
// }

// class Customer {
//   String name;
//   List<Order> orders = [];

//   Customer(this.name);

//   void addOrder(Order order) {
//     orders.add(order);
//   }

//   List<Order> getOrderHistory() {
//     return orders;
//   }
// }

// // 19. Наследование: Электроника
// class Device {
//   String brand;

//   Device(this.brand);

//   void turnOn() {
//     print('$brand device is turned on.');
//   }

//   void turnOff() {
//     print('$brand device is turned off.');
//   }
// }

// class Smartphone extends Device {
//   Smartphone(String brand) : super(brand);

//   void takePhoto() {
//     print('Taking a photo with $brand smartphone.');
//   }
// }

// class Laptop extends Device {
//   Laptop(String brand) : super(brand);

//   void code() {
//     print('Coding on $brand laptop.');
//   }
// }

// // 20. Игра "Крестики-нолики"
// class TicTacToeGame {
//   List<List<String>> board;
//   Player currentPlayer;
//   Player player1;
//   Player player2;

//   TicTacToeGame(this.player1, this.player2)
//       : currentPlayer = player1,
//         board = List.generate(3, (_) => List.generate(3, (_) => ''));

//   void makeMove(int row, int col) {
//     if (board[row][col] == '') {
//       board[row][col] = currentPlayer.symbol;
//       if (checkWin()) {
//         print('${currentPlayer.name} wins!');
//       } else {
//         currentPlayer = currentPlayer == player1 ? player2 : player1;
//       }
//     } else {
//       print('Invalid move.');
//     }
//   }

//   bool checkWin() {
//     for (int i = 0; i < 3; i++) {
//       if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '') {
//         return true;
//       }
//       if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '') {
//         return true;
//       }
//     }
//     if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '') {
//       return true;
//     }
//     if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '') {
//       return true;
//     }
//     return false;
//   }
// }

// void main() {
//   // Пример использования классов
//   Matrix m1 = Matrix([[1, 2], [3, 4]]);
//   Matrix m2 = Matrix([[5, 6], [7, 8]]);
//   Matrix sumMatrix = m1 + m2;
//   Matrix productMatrix = m1 * m2;
//   print('Sum Matrix: ${sumMatrix.data}');
//   print('Product Matrix: ${productMatrix.data}');

//   Player player = Player('Gamer', 100, 'X');
//   Enemy enemy = Enemy('Monster', 50);
//   Weapon weapon = Weapon('Sword', 20);
//   player.attack(enemy);
//   weapon.use(player, enemy);

//   Customer customer = Customer('John');
//   Order order = Order();
//   order.addProduct(Product('Laptop', 1000, 1));
//   customer.addOrder(order);
//   print('Customer Orders: ${customer.getOrderHistory()}');

//   Smartphone smartphone = Smartphone('Apple');
//   Laptop laptop = Laptop('Dell');
//   smartphone.turnOn();
//   smartphone.takePhoto();
//   laptop.turnOff();
//   laptop.code();

//   Player player1 = Player('Player 1', 100, 'X');
//   Player player2 = Player('Player 2', 100, 'O');
//   TicTacToeGame game = TicTacToeGame(player1, player2);
//   game.makeMove(0, 0);
//   game.makeMove(1, 1);
// }
