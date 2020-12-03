package daytwo

class DayTwo {
  private val data = DayTwoData.password
    .split("\n")
    .map(this::convertStringToPassword)

  private fun convertStringToPassword(passwordData: String): PasswordData {
    val values = passwordData.trim().split(" ")

    val minAndMaxCount = values[0].split('-')

    return PasswordData(
      minimumCount = minAndMaxCount[0].toInt(),
      maximumCount = minAndMaxCount[1].toInt(),
      character = values[1].first(),
      password = values[2]
    )
  }

  private fun validatePasswordPart1(passwordData: PasswordData): Boolean {
    val passwordCharacterCount =
      passwordData.password.fold(0) { acc, c -> if (c == passwordData.character) acc + 1 else acc }

    return passwordCharacterCount >= passwordData.minimumCount && passwordCharacterCount <= passwordData.maximumCount
  }

  private fun validatePasswordPart2(passwordData: PasswordData) =
    (passwordData.password[passwordData.minimumCount - 1] == passwordData.character &&
        passwordData.password[passwordData.maximumCount - 1] != passwordData.character) ||
        (passwordData.password[passwordData.minimumCount - 1] != passwordData.character &&
            passwordData.password[passwordData.maximumCount - 1] == passwordData.character)

  fun getValidPasswordCountPart1() = data.filter(this::validatePasswordPart1).size

  fun getValidPasswordCountPart2() = data.filter(this::validatePasswordPart2).size
}