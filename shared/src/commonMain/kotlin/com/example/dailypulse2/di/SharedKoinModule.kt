package com.example.dailypulse2.di

import com.example.dailypulse2.articles.di.articlesModule

val sharedKoinModule = listOf(
    articlesModule,
    networkModule
)