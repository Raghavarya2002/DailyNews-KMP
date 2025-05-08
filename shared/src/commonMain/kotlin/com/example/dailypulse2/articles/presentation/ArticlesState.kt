package com.example.dailypulse2.articles.presentation

import com.example.dailypulse2.articles.application.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)