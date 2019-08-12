package com.daovuu97.layoutpractice.service

import com.daovuu97.layoutpractice.model.Status
import com.daovuu97.layoutpractice.model.User
import java.util.*

object DataServices {
    val listUser = listOf(
        User(
            UUID.randomUUID().toString(),
            "Ronaldo",
            "https://mqttprject.000webhostapp.com/image/cristiano-ronaldo.jpg"
        ),
        User(UUID.randomUUID().toString(), "Messi", "https://mqttprject.000webhostapp.com/image/messi.jpg"),
        User(UUID.randomUUID().toString(), "Pogba", "https://mqttprject.000webhostapp.com/image/Paul_Pogba.jpg"),
        User(UUID.randomUUID().toString(), "Phuong", "https://mqttprject.000webhostapp.com/image/congphuong.jpg")
    )

    val listUser1 = listOf(
        User(listUser[0].userId, "Ronaldo", "https://mqttprject.000webhostapp.com/image/cristiano-ronaldo.jpg"),
        User(listUser[2].userId, "Pogba", "https://mqttprject.000webhostapp.com/image/Paul_Pogba.jpg")
    )
    val listStatus = listOf(
        Status(
            UUID.randomUUID().toString(), listUser[0].userId, listUser[0].userName, listUser[0].userImage,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                    + "Nunc fringilla cursus sodales. Proin hendrerit tempor purus eu posuere.",
            "", null, "123", "12",
            (System.currentTimeMillis() + 10)
        ),
        Status(
            UUID.randomUUID().toString(), listUser[1].userId, listUser[1].userName, listUser[1].userImage,
            "Has ${listUser.size} new connections", "", listUser, "123", "12",
            (System.currentTimeMillis() + 1200)
        ),
        Status(
            UUID.randomUUID().toString(), listUser[2].userId, listUser[2].userName, listUser[2].userImage,
            "", "https://mqttprject.000webhostapp.com/image/images.jpeg", null,
            "12", "12", (System.currentTimeMillis() + 1000)
        ),
        Status(
            UUID.randomUUID().toString(), listUser[3].userId, listUser[3].userName, listUser[3].userImage,
            "hello everyone i love you ", "", null, "1223",
            "122", System.currentTimeMillis()
        ),
        Status(
            UUID.randomUUID().toString(), listUser[0].userId, listUser[0].userName, listUser[0].userImage,
            "Has ${listUser1.size} new connections", "", listUser1, "123", "12",
            (System.currentTimeMillis() + 1200)
        ),
        Status(
            UUID.randomUUID().toString(), listUser[3].userId, listUser[3].userName, listUser[3].userImage,
            "Lorem ipsum dolor sit amet, " +
                    "consectetur adipiscing elit. Nunc fringilla cursus sodales. " +
                    "Proin hendrerit tempor purus eu posuere.",
            "https://mqttprject.000webhostapp.com/image/images.jpeg", null,
            "12", "12", (System.currentTimeMillis() + 1000)
        )
    )
}