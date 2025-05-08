package com.example.dailypulse2.android.di

import com.example.dailypulse2.articles.presentation.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module{
    viewModel{ ArticlesViewModel(get())}
}