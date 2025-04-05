package org.example.model

data class UserDTO(
    var name: String,
    var gitUsername: String,
    var followers: Int,
    var following: Int,
    var createdAt: String,
    var repos: List<String>
)