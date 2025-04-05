package org.example

import retrofit2.HttpException
import java.lang.Exception

interface Command {
    suspend fun execute(args: String, cache: Cache)
}

class UserInfoCommand : Command {
    override suspend fun execute(args: String, cache: Cache) {
        try {
            val foundUser = cache.findUser(args)
            if (foundUser == null) {
                val user = Dependencies.gitHub.getUserInfo(args)
                val repos = Dependencies.gitHub.getUserRepos(args)
                val publicRepos = repos.filter { !it.isPrivate }
                cache.save(user, publicRepos, args)
            }
        } catch (e: HttpException) {
            val error = Dependencies.gson.fromJson(
                e.response()?.errorBody()?.string(),
                ApiError::class.java
            )
            println(error)
        } catch (e: Exception) {
            println(e)
        }
    }
}

class GetUsersCommand : Command {
    override suspend fun execute(args: String, cache: Cache) {
        cache.findAll()
    }
}

class FindUserCommand : Command {
    override suspend fun execute(args: String, cache: Cache) {
        cache.findUser(args)
    }
}

class FindRepositoryCommand : Command {
    override suspend fun execute(args: String, cache: Cache) {
        cache.findRepository(args)
    }
}

class HelpCommand(private val config: Config) : Command {
    override suspend fun execute(args: String, cache: Cache) {
        println(config.help)
    }
}

class InvalidCommand : Command {
    override suspend fun execute(args: String, cache: Cache) {
        println("invalid input: $args")
    }
}