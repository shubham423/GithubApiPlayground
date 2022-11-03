package com.example.githubapiplayground.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


fun String.convertIntoDate(): String {
    val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val date: Date =
        dateFormat.parse(this) as Date //You will get date object relative to server/client timezone wherever it is parsed
    val formatter: DateFormat =
        SimpleDateFormat("yyyy-MM-dd") //If you need time just put specific format for time like 'HH:mm:ss'
    return formatter.format(date)
}
