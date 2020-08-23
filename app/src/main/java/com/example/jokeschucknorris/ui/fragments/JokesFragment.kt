package com.example.jokeschucknorris.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jokeschucknorris.R
import com.example.jokeschucknorris.mvp.model.JokesRepos
import com.example.jokeschucknorris.mvp.model.api.ApiHolder
import com.example.jokeschucknorris.mvp.presenter.JokesPresenter
import com.example.jokeschucknorris.mvp.view.JokesView
import com.example.jokeschucknorris.ui.adapter.JokesRVAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_jokes_list.*
import kotlinx.android.synthetic.main.item_joke.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class JokesFragment : MvpAppCompatFragment(), JokesView {

    companion object {
        fun newInstance() = JokesFragment()
    }

    @InjectPresenter
    lateinit var presenter: JokesPresenter
    var adapter: JokesRVAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        View.inflate(context, R.layout.fragment_jokes_list, null)


    @ProvidePresenter
    fun providePresenter() = JokesPresenter(
        AndroidSchedulers.mainThread(),
        JokesRepos(ApiHolder.api)
    )

    override fun init() {
        rv_jokes.layoutManager = LinearLayoutManager(context)
        adapter = JokesRVAdapter(presenter.jokeListPresenter)
        rv_jokes.adapter = adapter

    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun btnReload() {
        btn_reload.setOnClickListener {
            presenter.converterText(tv_counter.text)

        }


    }


    override fun setJoke(text: String) {
        tv_joke?.text = text
    }

}