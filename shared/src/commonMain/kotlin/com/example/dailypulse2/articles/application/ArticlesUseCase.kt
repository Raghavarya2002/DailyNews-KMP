package com.example.dailypulse2.articles.application

import com.example.dailypulse2.articles.data.ArticleRaw
import com.example.dailypulse2.articles.data.ArticlesService
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val service: ArticlesService) {

    suspend fun getArticles(): List<Article> {
        val articlesRaw = service.fetchArticles()
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map { raw ->
        Article(
            raw.title,
            raw.desc ?: "Click to find out more",
            convertDateTimeFormat(raw.date),
            raw.imageUrl
                ?: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
        )
    }


    private fun convertDateTimeFormat(dateTime: String): String {
        val today = Clock.System.todayIn(TimeZone.Companion.currentSystemDefault())
        val days = today.daysUntil(
            Instant.Companion.parse(dateTime).toLocalDateTime(TimeZone.Companion.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }


}