
/*
1. Write an object Conversions with methods inchesToCentimeters,
gallonsToLiters, and milesToKilometers.
*/

object Conversions {

  def inchesToCentimeters(inches: Double): Double = inches * 2.54

  def gallonsToLiters(gallons: Double): Double = gallons * 3.79

  def milesToKilometers(miles: Double): Double = miles * 1.61

}

Conversions.milesToKilometers(3)

/*
2. The preceding problem wasn’t very object-oriented. Provide a general superclass
UnitConversion and define objects InchesToCentimeters, GallonsToLiters,
and MilesToKilometers that extend it.
*/

class UnitConversion(val factor: Double) {
  def convert(value: Double): Double = factor * value
}

object InchesToSantimeters extends UnitConversion(2.54)
object GallonsToLiters extends UnitConversion(3.79)
object MilesToKilometers extends UnitConversion(1.61)

InchesToSantimeters.convert(2)

/*
3. Define an Origin object that extends java.awt.Point. Why is this not actually a good
idea? (Have a close look at the methods of the Point class.)
*/

object Origin extends java.awt.Point

// Its not a good idea since java.awt.Point class is mutable.
// I mean this class have a method move for example.

/*
4. Define a Point class with a companion object so that you can construct Point instances as
Point(3, 4), without using new.
*/

class Point(val x:Double, val y: Double)

object Point {
  def apply(x:Double, y: Double) = new Point(x, y)
}

val p = Point(1,2)

assert( p.x == 1.0)

/*
5. Write a Scala application, using the App trait, that prints its command-line arguments in
reverse order, separated by spaces. For example, scala Reverse Hello World should
print World Hello.
*/

object Reverse extends App {
  if (args.length > 0) println(args.reverse.mkString(" "))
}

/*
6. Write an enumeration describing the four playing card suits so that the toString method
returns ♣, ♦, ♥, or ♠.
*/

object CardSuits extends Enumeration {
  type CardSuits = Value
  val clubs = Value("♣")    // \u2663
  val diamonds = Value("♦") // \u2666
  val hearts = Value("♥")   // \u2665
  val spades = Value("♠")   // \u2660
}

for (c <- CardSuits.values) println(s"${c.id}: $c")

/*
7. Implement a function that checks whether a card suit value from the preceding exercise is red.
*/

def redChecker(cardSuit : CardSuits.Value): Boolean = cardSuit == CardSuits.diamonds || cardSuit == CardSuits.hearts

assert(redChecker(CardSuits.hearts))

/*
8. Write an enumeration describing the eight corners of the RGB color cube.
As IDs, use the color values (for example, 0xff0000 for Red ).
*/

object RGBColorCube extends Enumeration {
  val r = Value(0xff0000, "red")
  val g = Value(0x00ff00, "green")
  val b = Value(0x0000ff, "blue")
  val rg = Value(0xffff00, "red-green")
  val rb = Value(0xff00ff, "red-blue")
  val gb = Value(0x00ffff, "green-blue")
  val bl = Value(0x000000, "black")
  val wh = Value(0xffffff, "white")
}

for (c <- RGBColorCube.values) println(c.id + ":" + c)