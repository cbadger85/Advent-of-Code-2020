package dayone

class DayOne {
  private val numbers = DayOneData.numbers.split("\n").map { it.trim().toInt() }

  fun getTwoMultipliedNumber(): Int {
    for (firstNumber in numbers) {
      for (secondNumber in numbers) {
        if (firstNumber + secondNumber == 2020) return firstNumber * secondNumber
      }
    }
    throw Exception("There should be a solution here")
  }

  fun getThreeMultipliedNumber(): Int {
    for (firstNumber in numbers) {
      for (secondNumber in numbers) {
        for (thirdNumber in numbers) {
          if (firstNumber + secondNumber + thirdNumber == 2020)
            return firstNumber * secondNumber * thirdNumber

        }
      }
    }
    throw Exception("There should be a solution here")
  }
}