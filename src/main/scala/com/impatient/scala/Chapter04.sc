/*
1. Set up a map of prices for a number of gizmos that you covet. Then produce a second map with
the same keys and the prices at a 10 percent discount.
*/

val covetGizmos = Map("Apartment" -> 25000, "PC" -> 1000, "Bicycle" -> 600)

var discounted = for ((k, v) <- covetGizmos) yield (k, v * 0.9)

/*
2. Write a program that reads words from a file. Use a mutable map to count how often each word
appears. To read the words, simply use a java.util.Scanner:
val in = new java.util.Scanner(new java.io.File("myfile.txt"))
while (in.hasNext()) process in.next()
At the end, print out all words and their counts.
*/

val counts1 = scala.collection.mutable.Map[String, Int]()
val file1 = new java.io.File("/home/zvv/IdeaProjects/scala-impatient/src/main/scala/com/impatient/scala/test.txt")
val in1 = new java.util.Scanner(file1)
while (in1.hasNext()) {
  val word1 = in1.next()
  counts1(word1) = counts1.getOrElse(word1, 0) + 1
}
counts1


/*
3. Repeat the preceding exercise with an immutable map.
*/

var counts2 = Map[String, Int]()
val file2 = new java.io.File("/home/zvv/IdeaProjects/scala-impatient/src/main/scala/com/impatient/scala/test.txt")
val in2 = new java.util.Scanner(file2)
while (in2.hasNext()) {
  val word2 = in2.next()
  counts2 += (word2 -> (counts2.getOrElse(word2, 0) + 1))
}
counts2

/*
4. Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order.
*/

var counts3 = scala.collection.immutable.SortedMap[String, Int]()
val file3 = new java.io.File("/home/zvv/IdeaProjects/scala-impatient/src/main/scala/com/impatient/scala/test.txt")
val in3 = new java.util.Scanner(file3)
while (in3.hasNext()) {
  val word3 = in3.next()
  counts3 += (word3 -> (counts3.getOrElse(word3, 0) + 1))
}
counts3

/*
5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
*/

import scala.collection.JavaConverters.mapAsScalaMap

val counts4: scala.collection.mutable.Map[String, Int] = mapAsScalaMap(new java.util.TreeMap[String, Int])
val file4 = new java.io.File("/home/zvv/IdeaProjects/scala-impatient/src/main/scala/com/impatient/scala/test.txt")
val in4 = new java.util.Scanner(file4)
while (in4.hasNext()) {
  val word4 = in4.next()
  counts4(word4) = counts4.getOrElse(word4, 0) + 1
}
counts4

/*
6. Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and
similarly for the other weekdays. Demonstrate that the elements are visited in insertion order.
*/

val days = scala.collection.mutable.LinkedHashMap(
  "Monday" -> java.util.Calendar.MONDAY,
  "Tuesday" -> java.util.Calendar.TUESDAY,
  "Wednesday" -> java.util.Calendar.WEDNESDAY,
  "Thursday" -> java.util.Calendar.THURSDAY,
  "Friday" -> java.util.Calendar.FRIDAY,
  "Saturday" -> java.util.Calendar.SATURDAY,
  "Sunday" -> java.util.Calendar.SUNDAY
)

assert(days == (for (d <- days) yield d))

/*
  Print a table of all Java properties, like this:
  java.runtime.name | Java(TM) SE Runtime Environment
  sun.boot.library.path | /home/apps/jdk1.6.0_21/jre/lib/i386
  java.vm.version | 17.0-b16
  java.vm.vendor | Sun Microsystems Inc.
  java.vendor.url | http://java.sun.com/
  path.separator | :
  java.vm.name | Java HotSpot(TM) Server VM
  You need to find the length of the longest key before you can print the table
*/

import scala.collection.JavaConverters.propertiesAsScalaMap

val props: scala.collection.Map[String, String] = propertiesAsScalaMap(System.getProperties)

val maxLength = props.keys.maxBy(_.length).length

for ((k, v) <- props) println(k + " " * (maxLength - k.length) + "|" + v)


/*
8. Write a function minmax(values: Array[Int]) that returns a pair containing the
smallest and the largest values in the array.
*/

def minmax(values: Array[Int]) = values.min -> values.max

val values: Array[Int] = Array(1, 2, 7, 10, 8, 3)

minmax(values)

/*
9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple
containing the counts of values less than v, equal to v, and greater than v.
*/

def lteqgt(values: Array[Int], v: Int) = (values.count(_ < v), values.count(_ == v), values.count(_ > v))

val values2: Array[Int] = Array(1, 2, 7, 10, 3, 3)

lteqgt(values2, 3)

/*
10. What happens when you zip together two strings, such as "Hello".zip("World")? Come up with a plausible use case.
*/

"Hello".zip("World")

/*
It returns a Sequence of Tuple with characters from same position in each string
(H,W)
(e,o)
(l,r)
(l,l)
(o,d)
 */

"A plausible use case is cryptography"

"Hello".zip("World").map(t => s"${t._1}${t._2}").mkString
