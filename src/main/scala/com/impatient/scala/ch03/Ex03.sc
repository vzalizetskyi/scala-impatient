// 1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).

import scala.collection.mutable.ArrayBuffer
import util.Random

val n = 10
val a  = for (i <- 0 until n) yield Random.nextInt(n)

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

val array3= Array(-9, 0, 2, -22, 5)

val (o,t) = array3.partition( _ > 0)
o ++ t

//5. How do you compute the average of an Array[Double]?

val array4 = Array(3.1, 5.6, 3.14, 7, 1)
array.sum/array.length

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