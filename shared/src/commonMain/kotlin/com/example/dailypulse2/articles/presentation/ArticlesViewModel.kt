package com.example.dailypulse2.articles.presentation

import com.example.dailypulse2.BaseViewModel
import com.example.dailypulse2.Logger
import com.example.dailypulse2.articles.application.ArticlesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles() {
        scope.launch {
            _articlesState.emit(
                ArticlesState(
                    loading = true,
                    articles = _articlesState.value.articles
                )
            )
            delay(1000)
            val fetchedArticles = useCase.getArticles()
            Logger.Companion.d("ArticlesViewModel", fetchedArticles.toString())

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}