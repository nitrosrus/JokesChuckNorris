package com.example.jokeschucknorris.mvp.model

import com.example.jokeschucknorris.mvp.model.api.IDataSource
import io.reactivex.rxjava3.schedulers.Schedulers

class JokesRepos(val api: IDataSource) {
    fun getJoke(count: Int) = api.getJokes(count).subscribeOn(Schedulers.io())
}