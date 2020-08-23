package com.example.jokeschucknorris.ui.fragments

import com.example.jokeschucknorris.mvp.view.ApiWebView
import moxy.MvpAppCompatFragment

class ApiWebViewFragment : MvpAppCompatFragment(), ApiWebView {
    companion object {
        fun newInstance() = ApiWebViewFragment()
    }


}