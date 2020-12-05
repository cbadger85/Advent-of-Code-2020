package dayfive

import kotlin.math.pow

class DayFive {
  private val data = DayFiveData.boardingPasses.split("\n").map { it.trim() }

  private companion object {
    const val FRONT = 'F'
    const val BACK = 'B'
    const val LEFT = 'L'
    const val RIGHT = 'R'

    private const val TOTAL_ROWS: Int = 128
    private const val TOTAL_COLUMNS: Int = 8
  }

  private fun getRow(rowLocation: String) =
    rowLocation.foldIndexed(0) { i, rowNumber, row ->
      if (row == FRONT) rowNumber else rowNumber + (TOTAL_ROWS / 2f.pow(i + 1)).toInt()
  }

  private fun getColumn(columnLocation: String) =
    columnLocation.foldIndexed(0) { i, columnNumber, row ->
      if (row == LEFT) columnNumber else columnNumber + (TOTAL_COLUMNS / 2f.pow(i + 1)).toInt()
    }

  private fun getSeatId(seatLocation: String) =
    getRow(seatLocation.substring(0..6)) * 8 + getColumn(seatLocation.substring(7..9))

  fun getHighestSeatId() = data.map { getSeatId(it) }.maxOrNull()

  fun getMySeatId(): Int? {
    val seatIds = data.map { getSeatId(it) }.sorted()
    val allAvailableSeats = (seatIds.first()..seatIds.last()).filter { !seatIds.contains(it) }

    return allAvailableSeats.find { !allAvailableSeats.contains(it - 1) && !allAvailableSeats.contains(it + 1) }
  }
}