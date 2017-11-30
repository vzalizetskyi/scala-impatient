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


val counts = scala.collection.mutable.Map[String, Int]()
val in = new java.util.Scanner(new java.io.File("myfile.txt"))
while (in.hasNext()) {
  val word = in.next()
  counts(word) = counts.getOrElse(word, 0) + 1
}
println(counts)

*/
