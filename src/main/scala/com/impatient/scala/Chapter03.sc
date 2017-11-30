// 1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).

import scala.collection.mutable.ArrayBuffer
import util.Random

val n = 10
val a = for (i <- 0 until n) yield Random.nextInt(n)

/*
2. Write a loop that swaps adjacent elements of an array of integers. For example, Array(1,
2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
*/

val array = Array(1, 2, 3, 4, 5)

array.grouped(2).flatMap(_.reverse).toArray

/*
3. Repeat the preceding assignment, but produce a new array with the swapped values. Use
for/yield.
*/

val array2 = Array(1, 2, 3, 4, 5)

(for {x <- array2.grouped(2); y <- x.reverse} yield y).toArray

/*
4. Given an array of integers, produce a new array that contains all positive values of the original
array, in their original order, followed by all values that are zero or negative, in their original
order.
*/

val array3 = Array(-9, 0, 2, -22, 5)

val (o, t) = array3.partition(_ > 0)
o ++ t

//5. How do you compute the average of an Array[Double]?

val array4 = Array(3.1, 5.6, 3.14, 7, 1)
array.sum / array.length

/*
6. How do you rearrange the elements of an Array[Int] so that they appear in reverse sorted
order? How do you do the same with an ArrayBuffer[Int]?
*/

val array5 = Array(1, 2, 3, 4, 5).reverse

val array6 = ArrayBuffer(1, 2, 3, 4, 5).reverse

/*
7. Write a code snippet that produces all values from an array with duplicates removed. (Hint:
Look at Scaladoc.)
 */

val array7 = Array(5, 2, 3, 2, 5).distinct

/*
8. Suppose you are given an array buffer of integers and want to remove all but the first negative
number. Here is a sequential solution that sets a flag when the first negative number is called,
then removes all elements beyond.
var first = true
var n = a.length
var i = 0
while (i < n) {
if (a(i) >= 0) i += 1
else {
if (first) { first = false; i += 1 }
else { a.remove(i); n -= 1 }
}
}
This is a complex and inefficient solution. Rewrite it in Scala by collecting positions of the
negative elements, dropping the first element, reversing the sequence, and calling
a.remove(i) for each index.
*/

val array8 = ArrayBuffer(1, -2, -3, 4, -5)

val positionsOfTheNegativeElements = for (i <- array8.indices if array8(i) < 0) yield i

for (i <- positionsOfTheNegativeElements.drop(1).reverse) array8.remove(i)


/*
9. Improve the solution of the preceding exercise by collecting the positions that should be moved
and their target positions. Make those moves and truncate the buffer. Don’t copy any elements
before the first unwanted element.
 */


/*
10. Make a collection of all time zones returned by
java.util.TimeZone.getAvailableIDs that are in America. Strip off the
"America/" prefix and sort the result.
*/

import java.util.TimeZone

TimeZone.getAvailableIDs.filter(_.startsWith("America/")).map(_.stripPrefix("America/")).sorted

/*
11. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap
with the call
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
Then call the getNativesForFlavor method with parameter
DataFlavor.imageFlavor and get the return value as a Scala buffer. (Why this obscure
class? It’s hard to find uses of java.util.List in the standard Java library.)
*/

import scala.collection.JavaConverters
import scala.collection.mutable.Buffer
import java.awt.datatransfer._

val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
val flavorBuffer: Buffer[String] = JavaConverters.asScalaBufferConverter(flavors.getNativesForFlavor(DataFlavor.imageFlavor)).asScala