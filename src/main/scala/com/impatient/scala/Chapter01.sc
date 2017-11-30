/*
1. In the Scala REPL, type 3. followed by the Tab key. What methods can be applied?

!=   >             floatValue      isValidInt     to               toRadians
  %    >=            floor           isValidLong    toBinaryString   toShort
  &    >>            getClass        isValidShort   toByte           unary_+
  *    >>>           intValue        isWhole        toChar           unary_-
  +    ^             isInfinite      longValue      toDegrees        unary_~
-    abs           isInfinity      max            toDouble         underlying
/    byteValue     isNaN           min            toFloat          until
  <    ceil          isNegInfinity   round          toHexString      |
  <<   compare       isPosInfinity   self           toInt
<=   compareTo     isValidByte     shortValue     toLong
==   doubleValue   isValidChar     signum         toOctalString

2. In the Scala REPL, compute the square root of 3, and then square that value. By how much does
the result differ from 3? (Hint: The res variables are your friend.)
*/

import math.{pow, sqrt}

3 - pow(sqrt(3), 2)

/*
res0: Double = 4.440892098500626E-16

3. Are the res variables val or var?

When you try res0=5 the REPL showing the error "reassignment to val",
so res variables is val.

4. Scala lets you multiply a string with a number—try out "crazy" * 3 in the REPL. What
does this operation do? Where can you find it in Scaladoc?
*/

"crazy" * 3

/*
res1: String = crazycrazycrazy

def *(n: Int): String
Return the current string concatenated n times.
http://www.scala-lang.org/api/current/scala/collection/immutable/StringOps.html#*(n:Int):String

5. What does 10 max 2 mean? In which class is the max method defined?
*/

10 max 2

/*
res2: Int = 10

def max(that: Int): Int
Returns this if this > that or that otherwise.
http://www.scala-lang.org/api/current/scala/runtime/RichInt.html#max(that:Int):Int

6. Using BigInt, compute 2^1024.
*/

BigInt(2).pow(1024)

/*
7. What do you need to import so that you can get a random prime as probablePrime(100,
Random), without any qualifiers before probablePrime and Random?
*/

import util.Random
import BigInt.probablePrime

probablePrime(100, Random)

/*
8. One way to create random file or directory names is to produce a random BigInt and convert
it to base 36, yielding a string such as "qsnvbevtomcj38o06kul". Poke around Scaladoc
to find a way of doing this in Scala.
*/

res4.toString(36)

/*
9. How do you get the first character of a string in Scala? The last character?
*/
res5.head
res5.last

/*
10. What do the take, drop, takeRight, and dropRight string functions do? What
advantage or disadvantage do they have over using substring?
*/

res1.take(5)

/*
res8: String = crazy

def take(n: Int): String
Selects first n elements.

def drop(n: Int): String
Selects all elements except first n ones.

def takeRight(n: Int): String
Selects last n elements.

def dropRight(n: Int): String
Selects all elements except last n ones.

The new methods can be easily using together, and also using this methods by separate is easier to write and better for understanding.
*/