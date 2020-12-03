package daythree

class DayThree(
  private val originX: Int = 0,
  private val originY: Int = 0,
  private val deltaX: Int,
  private val deltaY: Int
) {
  private val data = DayThreeData.data
    .split('\n')
    .map { it.trim() }

  companion object {
    const val TREE = '#'
  }

  fun getNumberOfTrees() = countTrees(originX, originY, 0)

  private fun countTrees(colIdx: Int, rowIdx: Int, numberOfTrees: Int): Int {
    if (colIdx > data.lastIndex) {
      return numberOfTrees
    }

    val newTreeCount = if (data[colIdx][rowIdx] == TREE) numberOfTrees + 1 else numberOfTrees

    val isNextRowIndexGreaterThanRowLastIndex = rowIdx + deltaX > data[colIdx].lastIndex
    val nextRowIdx =
      if (isNextRowIndexGreaterThanRowLastIndex) rowIdx + deltaX - data[colIdx].length else rowIdx + deltaX

    return countTrees(colIdx + deltaY, nextRowIdx, newTreeCount)
  }
}