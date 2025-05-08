package com.example.dailypulse2.articles.di

import com.example.dailypulse2.articles.data.ArticlesService
import com.example.dailypulse2.articles.application.ArticlesUseCase
import com.example.dailypulse2.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> {
        ArticlesService(get())
    }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}