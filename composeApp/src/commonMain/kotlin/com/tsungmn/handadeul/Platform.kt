package com.tsungmn.handadeul

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform