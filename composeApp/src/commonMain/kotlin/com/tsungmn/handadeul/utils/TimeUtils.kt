package com.tsungmn.handadeul.utils

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.number

fun formatLocalDate(dateTime: LocalDate): String {
    val year = dateTime.year
    val month = dateTime.month.number
    val day = dateTime.day

    val dow = when (dateTime.dayOfWeek) {
        DayOfWeek.MONDAY -> "월요일"
        DayOfWeek.TUESDAY -> "화요일"
        DayOfWeek.WEDNESDAY -> "수요일"
        DayOfWeek.THURSDAY -> "목요일"
        DayOfWeek.FRIDAY -> "금요일"
        DayOfWeek.SATURDAY -> "토요일"
        DayOfWeek.SUNDAY -> "주일"
    }
    return "${year}년 ${month}월 ${day}일 $dow"
}
