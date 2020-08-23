package com.example.jokeschucknorris.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jokeschucknorris.R
import com.example.jokeschucknorris.mvp.presenter.IJokeListPresenter
import com.example.jokeschucknorris.mvp.view.JokeItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_joke.view.*

class JokesRVAdapter(val presenter: IJokeListPresenter) :
    RecyclerView.Adapter<JokesRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false))

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        presenter.bindView(holder)
    }


    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer, JokeItemView {

        override var pos = -1
        override fun setTextJoke(text: String) = with(containerView) {
            tv_joke.text = text
        }

    }


}