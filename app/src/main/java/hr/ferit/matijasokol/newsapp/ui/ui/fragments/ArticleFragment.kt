package hr.ferit.matijasokol.newsapp.ui.ui.fragments

import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import hr.ferit.matijasokol.newsapp.R
import hr.ferit.matijasokol.newsapp.ui.ui.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : BaseFragment(R.layout.fragment_article) {

    private val args: ArticleFragmentArgs by navArgs()

    override fun setUpUi() {
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(requireView(), getString(R.string.article_saved), Snackbar.LENGTH_SHORT).show()
        }
    }
}