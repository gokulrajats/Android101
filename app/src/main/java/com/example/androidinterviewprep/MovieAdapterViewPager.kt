package com.example.androidinterviewprep
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_recycler_layout.view.*

class MovieAdapterViewPager(val movies: List<Movie>): RecyclerView.Adapter<MovieAdapterViewPager.MovieViewHolder>() {

    class MovieViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_recycler_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.view.apply {
            textViewTitle.text = movie.title
            textViewLanguage.text = movie.language
            textViewRating.text = movie.rating
            textViewType.text = movie.type
            textViewLikePercent.text = movie.likePercent.toString() + "%"
            textViewVotesCount.text = movie.voteCount.toString() + "votes"
            textViewIsNew.visibility = if (movie.isNew) View.VISIBLE else View.GONE

        }
    }

    override fun getItemCount() = movies.size
}