package daythree

class DayThree(private val originX: Int = 0,
               private val originY: Int = 0,
               private val deltaX: Int,
               private val deltaY: Int) {
  private val data = DayThreeData.data
    .split('\n')
    .map { it.trim() }
  private val maxHeightIdx: Int = data.size - 1

  companion object {
    const val TREE = '#'
  }

  init {
    data.forEach { println(it) }
    println()
    println()
    println()
  }

  fun getNumberOfTrees(): Int {
    return getNumberOfTrees(originX, originY, 0)
  }

  private fun getNumberOfTrees(colIdx: Int, rowIdx: Int, numberOfTrees: Int): Int {
    if (colIdx > maxHeightIdx) {
      return numberOfTrees
    }

    val newTreeCount = if (data[colIdx][rowIdx] == TREE) numberOfTrees + 1 else numberOfTrees

    val nextRowIdx = if (rowIdx + deltaX > data[colIdx].lastIndex) rowIdx + deltaX - data[colIdx].length else rowIdx + deltaX

    return if (colIdx == 0 && rowIdx == 0) {
      getNumberOfTrees(colIdx + deltaY, deltaX, newTreeCount)
    } else {
      getNumberOfTrees(colIdx + deltaY, nextRowIdx, newTreeCount)
    }
  }
}