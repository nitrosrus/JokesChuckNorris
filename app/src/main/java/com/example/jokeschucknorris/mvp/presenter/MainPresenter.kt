package com.example.jokeschucknorris.mvp.presenter

import com.example.jokeschucknorris.mvp.view.MainView
import com.example.jokeschucknorris.ui.Screens
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class MainPresenter(val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        router.replaceScreen(Screens.JokesScreen())

    }

    fun goToJoke() {

        router.navigateTo(Screens.JokesScreen())
    }
    fun goToWeb() {
        //router.navigateTo(Screens.webScreen())
    }

}