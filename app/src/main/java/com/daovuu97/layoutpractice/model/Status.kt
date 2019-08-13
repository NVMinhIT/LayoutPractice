package com.daovuu97.layoutpractice.model

data class Status(
    val id: String, val userId: String,
    val userName: String, val userImage: String, val text: String,
    val image: String, val listConnecttion: List<User>?, val like: String,
    val comment: String, val time: Long, val color: Int
)