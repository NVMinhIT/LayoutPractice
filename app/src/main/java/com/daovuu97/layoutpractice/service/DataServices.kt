package com.daovuu97.layoutpractice.service

import com.daovuu97.layoutpractice.model.Status
import com.daovuu97.layoutpractice.model.User

object DataServices {
    val listUser = listOf(
        User("peter", "https://mqttprject.000webhostapp.com/image/tawdasd.jpeg"),
        User("dao vu", "https://mqttprject.000webhostapp.com/image/maxresdefault.jpg"),
        User("mete", "https://mqttprject.000webhostapp.com/image/270px-Atkinson_Rowan.jpg")
    )

    val listUser1 = listOf(
        User("peter", "https://mqttprject.000webhostapp.com/image/tawdasd.jpeg"),
        User("dao vu", "https://mqttprject.000webhostapp.com/image/maxresdefault.jpg"),
        User("mete", "https://mqttprject.000webhostapp.com/image/270px-Atkinson_Rowan.jpg"),
        User("dao vu", "https://mqttprject.000webhostapp.com/image/maxresdefault.jpg"),
        User("mete", "https://mqttprject.000webhostapp.com/image/270px-Atkinson_Rowan.jpg")
    )
    val listStatus = listOf(
        Status("tommy", "https://mqttprject.000webhostapp.com/image/tawdasd.jpeg",
            "it is good time!!", "", null, "123", "12",
            (System.currentTimeMillis()+10)
        ),
        Status("peter", "https://mqttprject.000webhostapp.com/image/maxresdefault.jpg",
            "Has ${listUser.size} new connections", "", listUser, "123", "12",
            (System.currentTimeMillis()+1200)
        ),
        Status("halo", "https://mqttprject.000webhostapp.com/image/270px-Atkinson_Rowan.jpg",
            "", "https://mqttprject.000webhostapp.com/image/images.jpeg", null,
            "12", "12", (System.currentTimeMillis()+1000)
        ),
        Status("halo", "https://mqttprject.000webhostapp.com/image/tawdasd.jpeg",
            "hello everyone i love you ", "", null, "1223",
            "122", System.currentTimeMillis()
        ),
        Status("peter", "https://mqttprject.000webhostapp.com/image/maxresdefault.jpg",
        "Has ${listUser1.size} new connections", "", listUser1, "123", "12",
        (System.currentTimeMillis()+1200)
         ),
        Status("jenny", "https://mqttprject.000webhostapp.com/image/270px-Atkinson_Rowan.jpg",
        "it is beautiful time", "https://mqttprject.000webhostapp.com/image/images.jpeg", null,
        "12", "12", (System.currentTimeMillis()+1000)
        ),
        Status("tren", "https://mqttprject.000webhostapp.com/image/tawdasd.jpeg",
        "hello everyone i love you ", "", null, "1223",
        "122", System.currentTimeMillis()
        )


    )
}