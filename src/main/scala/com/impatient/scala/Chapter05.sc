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
  def hours = _hours
  def hours_=(newValue: Int) {
  if (newValue > 0 && newValue < 23) _hours = newValue else _hours = 0
  }
  def before(other: Time): Boolean = hours < other.hours || hours <= other.hours && minutes < other.minutes

}

val time = new Time(-5,55)
val time2 = new Time(18,30)

s"Time1: ${time.hours} : ${time.minutes}"
s"Time2: ${time2.hours} : ${time2.minutes}"
s"Time1 before Time2: ${time.before(time2)}"