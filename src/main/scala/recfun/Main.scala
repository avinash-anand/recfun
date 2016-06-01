package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    val string1 = ")((()())()))(".toList
    println(balance(string1))
    val string2 = "((()())()))(".toList
    println(balance(string2))
    val string3 = "((()())()))".toList
    println(balance(string3))
    val string4 = "((()())())".toList
    println(balance(string4))
    val string5 = "abcd.".toList
    println(balance(string5))
  }

  /**
    * Exercise 1
    */
  // TODO: Try to implement in tail-recursive fashion
  def pascal(c: Int, r: Int): Int = {
    if ((c == 0) || (c == r)) 1
    else if (c > r) 0
    else if ((c < 0) || (r < 0)) 0
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def loop(acc: Int, xs: List[Char]): Boolean = {
      if (acc < 0) false
      else if (xs.isEmpty && acc > 0) false
      else if (xs.isEmpty && acc == 0) true
      else if (xs.head == '(') loop(acc + 1, xs.tail)
      else if (xs.head == ')') loop(acc - 1, xs.tail)
      else loop(acc, xs.tail)
    }
    loop(0, chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    0
  }
}
