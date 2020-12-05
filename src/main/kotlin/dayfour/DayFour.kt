package dayfour


class DayFour {
  private val data = DayFourData.passports.split("\n\n").map {
    it.split("\n", " ")
      .map { field -> field.trim().split(":").toPair() }
      .toMap()
  }

  companion object {
    const val BIRTH_YEAR = "byr"
    const val ISSUE_YEAR = "iyr"
    const val EXPIRATION_YEAR = "eyr"
    const val HEIGHT = "hgt"
    const val HAIR_COLOR = "hcl"
    const val EYE_COLOR = "ecl"
    const val PASSPORT_ID = "pid"
    const val COUNTRY_ID = "cid"
  }

  private fun getAllPassportsWithAllRequiredFields() = data.filter { passport ->
    listOf(
      BIRTH_YEAR,
      ISSUE_YEAR,
      EXPIRATION_YEAR,
      HEIGHT,
      HAIR_COLOR,
      EYE_COLOR,
      PASSPORT_ID
    ).all { passport.containsKey(it) }
  }

  fun getNumberOfPassportsWithRequiredFields() = getAllPassportsWithAllRequiredFields().size

  fun getNumberOfValidPassports() =
    getAllPassportsWithAllRequiredFields().filter {
      validateYear(it[BIRTH_YEAR]?.toInt() ?: 0, 1920, 2002) &&
          validateYear(it[ISSUE_YEAR]?.toInt() ?: 0, 2010, 2020) &&
          validateYear(it[EXPIRATION_YEAR]?.toInt() ?: 0, 2020, 2030) &&
          validateHeight(it[HEIGHT] ?: "") &&
          validateHairColor(it[HAIR_COLOR] ?: "") &&
          validateEyeColor(it[EYE_COLOR] ?: "") &&
          validatePassportId(it[PASSPORT_ID] ?: "")
    }.size

  private fun validateYear(year: Int, min: Int, max: Int) = year in max downTo min

  private fun validateHeight(height: String) =
    when {
      height.endsWith("cm") -> height.removeSuffix("cm").toIntOrNull()?.let { it in 193 downTo 150 }
        ?: false
      height.endsWith("in") -> height.removeSuffix("in").toIntOrNull()?.let { it in 76 downTo 59 }
        ?: false
      else -> false
    }

  private fun validateHairColor(color: String) = color.matches(Regex("^#([a-fA-F0-9]{6})\$"))

  private fun validateEyeColor(color: String) = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(color)

  private fun validatePassportId(pid: String) = pid.matches(Regex("^([0-9]{9})\$"))
}

fun <T> List<T>.toPair(): Pair<T, T> = this.takeIf { it.size == 2 }?.let { Pair(this.first(), this.last()) }
  ?: throw IllegalArgumentException("Size must be 2")