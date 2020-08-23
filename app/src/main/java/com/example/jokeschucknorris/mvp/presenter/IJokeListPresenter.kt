package com.example.jokeschucknorris.mvp.presenter

import com.example.jokeschucknorris.mvp.view.JokeItemView

interface IJokeListPresenter {
    fun getCount():Int
    fun bindView(view:JokeItemView)
}