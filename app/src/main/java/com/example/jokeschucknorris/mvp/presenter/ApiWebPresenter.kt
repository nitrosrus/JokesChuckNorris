package com.example.jokeschucknorris.mvp.presenter

import com.example.jokeschucknorris.mvp.view.ApiWebView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class ApiWebPresenter : MvpPresenter<ApiWebView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}