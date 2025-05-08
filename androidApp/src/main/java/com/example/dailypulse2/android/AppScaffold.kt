package com.example.dailypulse2.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dailypulse2.android.screens.AboutScreen
import com.example.dailypulse2.android.screens.ArticleScreen
import com.example.dailypulse2.android.screens.ScreenEnum
import com.example.dailypulse2.articles.presentation.ArticlesViewModel

@Composable
fun AppScaffold(){
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier =  Modifier.fillMaxSize().padding(it)
        )
    }
}

@Composable
 fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
){
     NavHost(
         navController = navController,
         startDestination = ScreenEnum.ARTICLES.route,
         modifier = modifier
     ){
         composable(ScreenEnum.ARTICLES.route){
             ArticleScreen(
                 onAboutButtonClick = {navController.navigate(ScreenEnum.ABOUT_DEVICE.route)}
             )
         }
         composable(ScreenEnum.ABOUT_DEVICE.route){
             AboutScreen(
                 onUpButtonClicked = {navController.popBackStack()},
             )
         }
     }

 }