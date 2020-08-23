package com.example.jokeschucknorris.mvp.presenter


import android.text.Editable
import com.example.jokeschucknorris.R
import com.example.jokeschucknorris.mvp.model.JokesRepos
import com.example.jokeschucknorris.mvp.model.entity.ValueJoke
import com.example.jokeschucknorris.mvp.view.JokeItemView
import com.example.jokeschucknorris.mvp.view.JokesView
import io.reactivex.rxjava3.core.Scheduler
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class JokesPresenter(
    val mainThreadScheduler: Scheduler,
    val jokesRepos: JokesRepos
) : MvpPresenter<JokesView>() {


    class JokeListPresenter : IJokeListPresenter {
        val jokes = mutableListOf<ValueJoke>()
        override fun getCount() = jokes.size
        override fun bindView(view: JokeItemView) {
            val valueJoke = jokes[view.pos]
            view.setTextJoke(valueJoke.joke.toString())

        }
    }

    val jokeListPresenter = JokeListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        //loadJokes(1)
        viewState.btnReload()

    }

    fun loadJokes(count: Int) {
        jokesRepos.getJoke(count).observeOn(mainThreadScheduler)
            .subscribe({ data ->
                jokeListPresenter.jokes.clear()
                jokeListPresenter.jokes.addAll(data.value)
                viewState.updateList()
            }, {

            })
    }

    fun converterText(text: Editable?) {
        if (text.isNullOrEmpty() ) {
        } else loadJokes(text.toString().toInt())

    }


}