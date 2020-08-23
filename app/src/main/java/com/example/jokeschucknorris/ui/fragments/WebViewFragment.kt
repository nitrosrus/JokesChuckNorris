package com.example.jokeschucknorris.ui.fragments

import com.example.jokeschucknorris.mvp.view.WebView
import moxy.MvpAppCompatFragment

class WebViewFragment : MvpAppCompatFragment(), WebView {
    companion object {
        fun newInstance() = WebViewFragment()
    }


}