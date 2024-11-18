//package com.example.newsheadlines
//
//import android.util.Log
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.example.Articles
//import kotlinx.coroutines.launch
//
//class MainViewModel : ViewModel() {
//    var movieListResponse:List<Articles> by mutableStateOf(listOf())
//    var errorMessage: String by mutableStateOf("")
//    fun getMovieList() {
//        viewModelScope.launch {
//            val apiService = ApiService.getInstance()
//            try {
//                val movieList = apiService.getMovies()
//                movieListResponse = movieList.articles
//            }
//            catch (e: Exception) {
//                errorMessage = e.message.toString()
////            }
//        }
//    }
//}
// 2
//package com.example.newsheadlines
//
//import android.util.Log
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.example.Articles
//import kotlinx.coroutines.launch
//
//class MainViewModel : ViewModel() {
//    var movieListResponse = mutableStateOf<List<Articles>>(listOf())
//    var errorMessage = mutableStateOf("")
//
//    fun getMovieList() {
//        viewModelScope.launch {
//            val apiService = ApiService.getInstance()
//            try {
//                val movieList = apiService.getMovies()
//                movieListResponse.value = movieList.articles
//            } catch (e: Exception) {
//                errorMessage.value = e.message.toString()
//                Log.e("MainViewModel", "Error fetching movies: ${e.message}")
//            }
//        }
//    }
//}
package com.example.newsheadlines

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Articles
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var movieListResponse: List<Articles> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    private val apiKey = "2ce94189ae2546dabbb207238827a402" // Your API key

    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                // Now we pass the API key correctly
                val movieList = apiService.getMovies(apiKey = apiKey) // Pass the API key here
                movieListResponse = movieList.articles
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                Log.e("MainViewModel", "Error fetching movies: $errorMessage")
            }
        }
    }
}

