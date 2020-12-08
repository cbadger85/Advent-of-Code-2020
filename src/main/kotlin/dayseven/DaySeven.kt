package dayseven

class DaySeven {
  private val data = DaySevenData.bags.split("\n").map {
    val filters = listOf("bags,", "bag,", "bags.", "bag.", "bag", "bags", "contains", "contain")
    val bagInfo = it.split(" ").filter { word -> !filters.contains(word.toLowerCase()) }

    val color = listOf(bagInfo[0], bagInfo[1]).joinToString(" ")

    if (bagInfo.contains("no")) {
      Pair(color, emptyList())
    } else {
      bagInfo.subList(2, bagInfo.size).chunked(3)
        .map { data -> BagCountData(data.first().toInt(), data.subList(1, data.size).joinToString(" ")) }
        .let { bagList -> Pair(color, bagList) }
    }
  }.toMap()

  fun getBagCountContainingGoldBags() = getBagsContainingColoredBag().size

  private tailrec fun getBagsContainingColoredBag(
    colors: List<String> = listOf("shiny gold"),
    bagsContainingColor: List<String> = listOf()
  ): List<String> {
    val bags = data.entries.fold(listOf<String>()) { acc, bagMap ->
      if (bagMap.value.any { bagCountData ->
          colors.contains(bagCountData.color)
        }) listOf(bagMap.key) + acc else acc
    }

    if (bags.isEmpty()) {
      return bagsContainingColor;
    }

    return getBagsContainingColoredBag(bags, (bags + bagsContainingColor).distinct())
  }

  fun getNumberOfBagsInGoldBags(): Int {
    return getNumberOfBagsInBags() - 1
  }

  private fun getNumberOfBagsInBags(color: String = "shiny gold"): Int {
    return data[color]?.fold(1) { acc, bagCountData ->
      (bagCountData.count.takeIf { count -> count != 0 } ?: 1) * getNumberOfBagsInBags(
        bagCountData.color
      ) + acc
    } ?: 0
  }

  private data class BagCountData(val count: Int, val color: String)
}