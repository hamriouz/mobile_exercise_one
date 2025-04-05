package org.example

import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("/users/{user}")
    suspend fun getUserInfo(@Path("user") user: String): GitHubUser

    @GET("/users/{user}/repos")
    suspend fun getUserRepos(@Path("user") user: String): List<GitHubRepository>
}

