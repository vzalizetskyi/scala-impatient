/*
1. Improve the Counter class in Section 5.1, “Simple Classes and Parameterless Methods,” on
page 55 so that it doesn’t turn negative at Int.MaxValue.
*/

class Counter {
  private var value = 0 // You must initialize the field
  def increment() { // Methods are public by default
    if (value < Int.MaxValue) value += 1 else value = 0
  }

  def current = value
}

/*
2. Write a class BankAccount with methods deposit and withdraw, and a read-only
property balance.
*/

class BankAccount {
  private var privateBalance: Double = 0.0

  def deposit(value: Int) {
    privateBalance += value
  }

  def withdraw(value: Int) {
    privateBalance -= value
  }

  def balance = privateBalance

}

val myBA = new BankAccount

myBA.deposit(500)
myBA.withdraw(150)
myBA.balance

/*
3. Write a class Time with read-only properties hours and minutes and a method
before(other: Time): Boolean that checks whether this time comes before the other.
A Time object should be constructed as new Time(hrs, min), where hrs is in military
time format (between 0 and 23).
*/

class Time(private var _hours: Int, val minutes: Int) {

  if (_hours < 0 || _hours > 23) _hours = 0

  def hours = _hours

  def before(other: Time): Boolean = hours < other.hours || hours <= other.hours && minutes < other.minutes

}

val time = new Time(25, 25)
val time2 = new Time(18, 30)

s"Time1: ${time.hours} : ${time.minutes}"
s"Time2: ${time2.hours} : ${time2.minutes}"
s"Time1 before Time2: ${time.before(time2)}"


/*
4. Reimplement the Time class from the preceding exercise so that the internal representation is
the number of minutes since midnight (between 0 and 24 × 60 – 1). Do not change the public
interface. That is, client code should be unaffected by your change.
*/

class Time2(val hours: Int, val minutes: Int) {
  private val _time = hours * 60 + minutes

  def before(other: Time2): Boolean = _time < other._time

}

val time3 = new Time2(18, 25)
val time4 = new Time2(18, 30)

s"Time1: ${time3.hours} : ${time3.minutes}"
s"Time2: ${time4.hours} : ${time4.minutes}"
s"Time1 before Time2: ${time3.before(time4)}"

/*
5. Make a class Student with read-write JavaBeans properties name (of type String) and
id (of type Long). What methods are generated? (Use javap to check.) Can you call the
JavaBeans getters and setters in Scala? Should you?
*/

import scala.beans.BeanProperty

class Student(@BeanProperty var name: String, @BeanProperty var id: Long)

/* javap =>
method generated are getId, setId, getName, setName
public class Student {
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public void setName(java.lang.String);
  public long id();
  public void id_$eq(long);
  public void setId(long);
  public java.lang.String getName();
  public long getId();
  public Student(java.lang.String, long);
}
*/

val John = new Student("John", 2457)

/*
Yes you can call getters and setters but you should not use them directly
It's only necessary to get compatibility with Library that uses Bean
 */
assert(John.getId == John.id)

/*
6. In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,” on page 55,
provide a primary constructor that turns negative ages to 0.
*/

class Person(private var _age: Int) {

  if (_age < 0) _age = 0

  def age = _age

  def age_=(newValue: Int) {
    if (newValue > _age) _age = newValue
  }
}

val Vasya = new Person(-26)

assert(Vasya.age == 0)

/*
7. Write a class Person with a primary constructor that accepts a string containing a first name,
a space, and a last name, such as new Person("Fred Smith"). Supply read-only properties firstName and lastName.
Should the primary constructor parameter be a var, a val, or a plain parameter? Why?
*/

/*
Primary constructor parameter should be a plain parameter
*/

class Person2(fullName: String) {
  val (firstName: String, lastName: String) = fullName.split(" ") match {
    case Array(x: String, y: String, _*) => (x, y)
    case _ => (" ", " ")
  }

}

val FredSmith = new Person2("Fred Smith")

assert(FredSmith.firstName == "Fred")
assert(FredSmith.lastName == "Smith")

/*
8. Make a class Car with read-only properties for manufacturer, model name, and model year,
and a read-write property for the license plate. Supply four constructors. All require the
manufacturer and model name. Optionally, model year and license plate can also be specified in
the constructor. If not, the model year is set to -1 and the license plate to the empty string.
Which constructor are you choosing as the primary constructor? Why?
*/

/*
As a primary constructor was chosen the constructor that takes all parameters, because for defining another
constructors, we can simply call this constructor with some default values.
*/

class Car(val manufacturer: String, val modelName: String, modelYear: Int = -1, var licensePlate: String = "") {
  def this(manufacturer: String, modelName: String, licensePlate: String) = {
    this(manufacturer, modelName, -1, licensePlate)
  }
}

/*
9. Reimplement the class of the preceding exercise in Java, C#, or C++ (your choice). How much
shorter is the Scala class?
*/

// TODO: realize the 9 exercise form chapter 5

/*
10. Consider the class
  class Employee(val name: String, var salary: Double) {
    def this() { this("John Q. Public", 0.0) }
  }
Rewrite it to use explicit fields and a default primary constructor. Which form do you prefer? Why?
*/

class Employee10 {
  val name: String = "John Q. Public"
  var salary: Double = 0.0
}