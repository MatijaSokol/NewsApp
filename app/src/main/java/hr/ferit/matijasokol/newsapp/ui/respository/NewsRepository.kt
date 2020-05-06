package hr.ferit.matijasokol.newsapp.ui.respository

import hr.ferit.matijasokol.newsapp.ui.networking.RetrofitInstance
import hr.ferit.matijasokol.newsapp.ui.db.ArticleDatabase
import hr.ferit.matijasokol.newsapp.ui.models.Article

class NewsRepository(private val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}