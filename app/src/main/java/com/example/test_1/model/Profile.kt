package com.example.test_1.model

data class Profile(
    val success: Boolean,
    val message: String,
    val full_name: String,
    val position: String,
    val history: List<HistoryItem>
)

data class HistoryItem(
    val title: String,
    val is_up: Boolean
)
