/*
1. The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero.
  Write a function that computes this value.
*/

def signum(number: Int): Int = {
  if (number > 0) 1 else if (number < 0) -1 else 0
}

signum(5)
signum(-5)
signum(0)

/*
res0: Int = 1
res1: Int = -1
res2: Int = 0
*/

//2. What is the value of an empty block expression {}? What is its type?

{}

//res3: Unit = ()

/*
3. Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a
  suitable type for x.)
*/

var y = 0
val x: Unit = y = 1

/*
4. Write a Scala equivalent for the Java loop
for (int i = 10; i >= 0; i--) System.out.println(i);
*/

for (i <- 10 to(0, -1)) yield i

//5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.

def countdown(n: Int) {
  for (i <- n to(0, -1)) print(i + " ")
}

countdown(5)

/*
6. Write a for loop for computing the product of the Unicode codes of all letters in a string. For
example, the product of the characters in "Hello" is 9415087488L.
*/

var result: Long = 1
for (ch <- "Hello") result *= ch.toLong
result

/*
7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps
Scaladoc.)
*/

"Hello".map(_.toLong).product

/*
8. Write a function product(s : String) that computes the product, as described in the
preceding exercises.
*/

def product(s: String) = {
  s.map(_.toLong).product
}

product("Hello")

//9. Make the function of the preceding exercise a recursive function.

def recursiveProduct(s: String): Long = {
  if (s.tail != "") s.head.toLong * recursiveProduct(s.tail) else s.head.toLong
}

recursiveProduct("Hello")

/*
10. Write a function that computes x^n , where n is an integer. Use the following recursive
definition:
• x^n = y · y if n is even and positive, where y = x^n / 2 .
• x^n = x · x^n – 1 if n is odd and positive.
• x^0 = 1.
• x^n = 1 / x – n if n is negative.
Don’t use a return statement.
*/

import math.pow

def func(x: Double, n: Int): Double = {
  if (n > 0 && n % 2 == 0) {
    val y = pow(x, n) / 2
    y * y
  }
  else if (n > 0 && n % 2 != 0) x * pow(x, n - 1)
  else if (n < 0) 1 / x - n
  else 1
}

func(10, 2)

/*
11. Define a string interpolator date so that you can define a java.time.LocalDate as
date"$year-$month-$day". You need to define an “implicit” class with a date
method, like this:
implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
def date(args: Any*): LocalDate = . . .
}
args(i) is the value of the ith expression. Convert each to a string and then to an integer, and
pass them to the LocalDate.of method. If you already know some Scala, add error
handling. Throw an exception if there aren’t three arguments, or if they aren’t integers, or if they
aren’t separated by dashes. (You get the strings in between the expressions as sc.parts.)
*/

import java.time.LocalDate

implicit class DateInterpolator(val sc: StringContext) extends AnyVal {

  def date(args: Any*): LocalDate = {
    try {
      if (args.length != 3) throw new IllegalArgumentException("there aren’t three arguments")
      val (year, month, day) = (args(0).toString.toInt, args(1).toString.toInt, args(2).toString.toInt)
      for (x <- sc.parts) if (x.length > 0 && !x.equals("-")) throw new IllegalArgumentException("Date parts aren’t separated by dashes")
      LocalDate.of(year, month, day)
    }
    catch {
      case ex: NumberFormatException =>
        println("Date parts aren’t integer")
        throw ex
      case ex: IllegalArgumentException =>
        println("See exception message for detail")
        throw ex
    }
  }
}

val year = 2017
val month = 11
val day = 30

date"$year#$month-$day"
