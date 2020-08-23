package com.example.jokeschucknorris.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface JokesView : MvpView {
    fun init()
    fun updateList()
    fun btnUpdate()
    fun setJoke(text: String)
}