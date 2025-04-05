package org.example

class Config {
    val help: String = """
        Help:
        - get users: to get all the users saved in memory
        - user info: to save the information of a new user
        - find user: to get the data of a specific user
        - find repository: to get the data of a specific repository
    """.trimIndent()

    val greeting: String = """
        Welcome! If you need help, type "help".
    """.trimIndent()

    val exit: String = """
        Come back soon!
    """.trimIndent()
}
