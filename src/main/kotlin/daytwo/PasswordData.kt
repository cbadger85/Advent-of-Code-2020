package daytwo

data class PasswordData(val character: Char,
                        val minimumCount: Int,
                        val maximumCount: Int,
                        val password: String)