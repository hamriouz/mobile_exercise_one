package org.example

class UserMenu (
    private val config: Config,
    private val cache: Cache,
) {
    private val commandMap: Map<String, Command> = mapOf(
        "user info" to UserInfoCommand(),
        "get users" to GetUsersCommand(),
        "find user" to FindUserCommand(),
        "find repository" to FindRepositoryCommand(),
        "help" to HelpCommand(config)
    )

    suspend fun getUserInfo() {
        while (true) {
            val userInput = readln().lowercase().trim()
            if (userInput == "exit") {
                println(config.exit)
                break
            }
            changePage(userInput)
        }
    }

    private suspend fun changePage(userInput: String) {
        val matchedEntry = commandMap.entries.firstOrNull { userInput.startsWith(it.key) }

        if (matchedEntry != null) {
            val command = matchedEntry.value
            val args = userInput.removePrefix(matchedEntry.key).trim()
            command.execute(args, cache)
        } else {
            InvalidCommand().execute(userInput, cache)
        }
    }
}
