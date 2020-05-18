package hr.ferit.matijasokol.newsapp.ui.ui.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import hr.ferit.matijasokol.newsapp.R
import hr.ferit.matijasokol.newsapp.ui.db.ArticleDatabase
import hr.ferit.matijasokol.newsapp.ui.respository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    private val newsRepository by lazy { NewsRepository(ArticleDatabase(this)) }
    private val viewModelProviderFactory by lazy { NewsViewModelProviderFactory(application, newsRepository) }
    val viewModel by lazy { ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}
