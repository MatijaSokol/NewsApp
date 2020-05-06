package hr.ferit.matijasokol.newsapp.ui.ui.fragments.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import hr.ferit.matijasokol.newsapp.ui.ui.news.NewsActivity
import hr.ferit.matijasokol.newsapp.ui.ui.news.NewsViewModel

abstract class BaseFragment(layoutResourceId: Int) : Fragment(layoutResourceId) {

    val viewModel by lazy { (activity as NewsActivity).viewModel }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUi()
    }

    abstract fun setUpUi()
}