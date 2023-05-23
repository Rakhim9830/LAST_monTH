package com.example.last_month.domain.model

import java.io.Serializable

class Note(
    val id: Int = DEFAULT_ID,
    var title: String,
    var desc: String

): Serializable {
    companion object{
        const val DEFAULT_ID = 0
    }
}
