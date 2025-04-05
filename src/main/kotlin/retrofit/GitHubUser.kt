package org.example

import com.google.gson.annotations.SerializedName

data class GitHubUser(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("followers") val followers: Int,
    @SerializedName("following") val following: Int,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("public_repos") val publicRepos: Int,
)
