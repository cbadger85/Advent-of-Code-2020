import dayfive.DayFive
import dayfour.DayFour
import dayone.DayOne
import dayseven.DaySeven
import daysix.DaySix
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

  println()

  println("Day Four Advent of Code 2020 Part 1 Solution - ${DayFour().getNumberOfPassportsWithRequiredFields()}")
  println("Day Four Advent of Code 2020 Part 2 Solution - ${DayFour().getNumberOfValidPassports()}")

  println()

  println("Day Five Advent of Code 2020 Part 1 Solution - ${DayFive().getHighestSeatId()}")
  println("Day Five Advent of Code 2020 Part 2 Solution - ${DayFive().getMySeatId()}")

  println()

  println("Day Six Advent of Code 2020 Part 1 Solution - ${DaySix().partOneSolution()}")
  println("Day Five Advent of Code 2020 Part 2 Solution - ${DaySix().partTwoSolution()}")

  println()

  println("Day Seven Advent of Code 2020 Part 1 Solution - ${DaySeven().getBagCountContainingGoldBags()}")
  println("Day Seven Advent of Code 2020 Part 2 Solution - ${DaySeven().getNumberOfBagsInGoldBags()}")
}