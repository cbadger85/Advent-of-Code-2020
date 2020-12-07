package daysix

class DaySix {
  private val data = DaySixData.answers.split("\n\n").map { it.trim().split("\n") }

  fun partOneSolution() = data.map { it.joinToString("").toCharArray().distinct().size }.sum()

  fun partTwoSolution(): Int {
    return data.map {
      it.joinToString("").toCharArray().fold(mutableMapOf<Char, Int>()) { acc, c ->
        acc[c] = acc[c]?.plus(1) ?: 1

        acc
      }.filter { map -> map.value == it.size }.toList().size
    }.sum()
  }
}