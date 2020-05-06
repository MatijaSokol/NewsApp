package hr.ferit.matijasokol.newsapp.ui.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.matijasokol.newsapp.R
import hr.ferit.matijasokol.newsapp.ui.models.Article
import hr.ferit.matijasokol.newsapp.ui.util.loadImage
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsAdapter(private val onItemClicked: (Article) -> Unit) : ListAdapter<Article, NewsAdapter.ArticleViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {

            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article_preview, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    operator fun get(position: Int): Article = getItem(position)

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(article: Article) {
            with(itemView) {
                ivArticleImage.loadImage(article.urlToImage)
                tvSource.text = article.source?.name
                tvTitle.text = article.title
                tvDescription.text = article.description
                tvPublishedAt.text = article.publishedAt

                setOnClickListener { onItemClicked(article) }
            }
        }
    }
}