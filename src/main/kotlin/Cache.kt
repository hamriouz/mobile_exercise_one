package org.example

import org.example.model.UserDTO

class Cache {
    var users: MutableList<UserDTO> = mutableListOf()

    fun save(user: GitHubUser, publicRepos: List<GitHubRepository>, githubUsername: String) {
        val userDTO = UserDTO(user.name, githubUsername, user.followers, user.following, user.createdAt, publicRepos.map { it.name })
        users.add(userDTO)
        println("user info: $userDTO")
    }

    fun findUser(username: String): UserDTO? {
        val foundUser = users.firstOrNull { user ->
            user.gitUsername.equals(username, ignoreCase = true)
        }
        if (foundUser != null) {
            println("foundUser: $foundUser")
        } else {
            println("user does not exist in cache")
        }
        return foundUser
    }

    fun findAll() {
         println(users)
    }

    fun findRepository(repoName: String) {
        val foundUser = users.firstOrNull { user ->
            user.repos.any { repo -> repo.equals(repoName, ignoreCase = true) }
        }
        if (foundUser != null) {
            println("foundUser: $foundUser")
        } else {
            println("repo not found")
        }
    }

}