package hr.ferit.matijasokol.newsapp.ui.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hr.ferit.matijasokol.newsapp.ui.respository.NewsRepository

class NewsViewModelProviderFactory(private val newsRepository: NewsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(
            newsRepository
        ) as T
    }
}