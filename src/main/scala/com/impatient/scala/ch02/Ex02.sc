/*
1. The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero.
  Write a function that computes this value.
*/

def signum (number: Int) : Int = {
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
val x:Unit = y = 1

/*
4. Write a Scala equivalent for the Java loop
for (int i = 10; i >= 0; i--) System.out.println(i);
*/

for (i <- 10 to (0,-1)) yield i

//5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.

def countdown (n: Int) {
  for (i <- n to (0,-1)) print(i+" ")
}

countdown(5)

/*
6. Write a for loop for computing the product of the Unicode codes of all letters in a string. For
example, the product of the characters in "Hello" is 9415087488L.
*/

var res : Long = 1
for (ch <- "Hello") res *= ch.toLong
res