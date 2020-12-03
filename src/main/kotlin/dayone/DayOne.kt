package dayone

class DayOne {
  private fun getData() = DayOneData.numbers.split("\n").map { it.trim().toInt() }

  fun getTwoMultipliedNumber(): Int {
    val numbers = getData()

    for (firstNumber in numbers) {
      for (secondNumber in numbers) {
        if (firstNumber + secondNumber == 2020) return firstNumber * secondNumber
      }
    }
    throw Exception()
  }

  fun getThreeMultipliedNumber(): Int {
    val numbers = getData()

    for (firstNumber in numbers) {
      for (secondNumber in numbers) {
        for (thirdNumber in numbers) {
          if (firstNumber + secondNumber + thirdNumber == 2020)
            return firstNumber * secondNumber * thirdNumber

        }
      }
    }
    throw Exception()
  }
}