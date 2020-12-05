package dayfive

import kotlin.math.pow

class DayFive(private val totalRows: Int = 128, private val totalColumns: Int = 8) {
  private val data = DayFiveData.boardingPasses.split("\n").map { it.trim() }

  companion object {
    const val FRONT = 'F'
    const val BACK = 'B'
    const val LEFT = 'L'
    const val RIGHT = 'R'
  }

  private fun getRow(rowLocation: String) =
    rowLocation.foldIndexed(0) { i, acc, row ->
      if (row == FRONT) acc else acc + (totalRows / 2f.pow(i + 1)).toInt()
  }

  private fun getColumn(columnLocation: String) =
    columnLocation.foldIndexed(0) { i, acc, row ->
      if (row == LEFT) acc else acc + (totalColumns / 2f.pow(i + 1)).toInt()
    }

  private fun getSeatId(seatLocation: String) =
    getRow(seatLocation.substring(0, 7)) * 8 + getColumn(seatLocation.substring(7, 10))

  fun getHighestSeatId() = data.map(this::getSeatId).maxOrNull()

  fun getMySeatId(): Int {
    val seatIds = data.map(this::getSeatId).sorted()
    val allAvailableSeats = (seatIds.first()..seatIds.last()).filter { !seatIds.contains(it) }

    return allAvailableSeats.find { !allAvailableSeats.contains(it - 1) && !allAvailableSeats.contains(it + 1) } ?: 0
  }
}

