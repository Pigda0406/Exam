package com.martin.exam.github.data

data class Users(
    val login: String,
    val id: String,
    val node_id: String,
    val avatar_url: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
    val events_url: String,
    val received_events_url: String,
    val type: String,
    val site_admin: Boolean,
    val name: String,
    val public_repos: Int,
    val public_gists: Int,
    val followers: Int,
    val following: Int,
    val email: String,
    val blog: String,
    val company: String?,
    val location: String,
    val bio: String,
    val total_private_repos: Int
)