import dayone.DayOne
import daythree.DayThree
import daytwo.DayTwo

fun main(args: Array<String>) {
  println("Day One Advent of Code 2020 Part 1 Solution - ${DayOne().getTwoMultipliedNumber()}")
  println("Day One Advent of Code 2020 Part 2 Solution - ${DayOne().getThreeMultipliedNumber()}")

  println()

  println("Day Two Advent of Code 2020 Part 1 Solution - ${DayTwo().getValidPasswordCountPart1()}")
  println("Day Two Advent of Code 2020 Part 2 Solution - ${DayTwo().getValidPasswordCountPart2()}")

  println()

  println("Day Three Advent of Code 2020 Part 1 Solution - ${DayThree(deltaX = 3, deltaY = 1).getNumberOfTrees()}")
  val partTwoSlopes = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
  val partTwoSolution = partTwoSlopes.fold(1.toBigInteger()) { acc, pair ->
    DayThree(
      deltaX = pair.first,
      deltaY = pair.second
    ).getNumberOfTrees().toBigInteger() * acc
  }
  println("Day Three Advent of Code 2020 Part 2 Solution - $partTwoSolution")
}