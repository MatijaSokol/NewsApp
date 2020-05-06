package hr.ferit.matijasokol.newsapp.ui.ui.fragments

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import hr.ferit.matijasokol.newsapp.R
import hr.ferit.matijasokol.newsapp.ui.models.Article
import hr.ferit.matijasokol.newsapp.ui.ui.adapters.ItemTouchHelperCallback
import hr.ferit.matijasokol.newsapp.ui.ui.adapters.NewsAdapter
import hr.ferit.matijasokol.newsapp.ui.ui.fragments.base.BaseFragment
import hr.ferit.matijasokol.newsapp.ui.util.Constants.BUNDLE_ARTICLE
import kotlinx.android.synthetic.main.fragment_saved_news.*

class SavedNewsFragment : BaseFragment(R.layout.fragment_saved_news) {

    private val newsAdapter by lazy { NewsAdapter { onItemClicked(it) } }
    private val itemTouchHelperCallback by lazy { ItemTouchHelperCallback { onItemSwiped(it) } }

    override fun setUpUi() {
        setupRecycler()

        viewModel.getSavedNews().observe(viewLifecycleOwner, Observer { articles ->
            newsAdapter.submitList(articles)
        })
    }

    private fun onItemClicked(article: Article) {
        val bundle = Bundle().apply {
            putParcelable(BUNDLE_ARTICLE, article)
        }
        findNavController().navigate(R.id.action_savedNewsFragment_to_articleFragment, bundle)
    }

    private fun onItemSwiped(position: Int) {
        val article = newsAdapter[position]
        viewModel.deleteArticle(article)
        Snackbar.make(requireView(), getString(R.string.delete), Snackbar.LENGTH_LONG).apply {
            setAction(getString(R.string.undo)) {
                viewModel.saveArticle(article)
            }
                .show()
        }
    }

    private fun setupRecycler() {
        rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(this)
            setHasFixedSize(true)
        }
    }
}