package com.example.jokeschucknorris.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jokeschucknorris.R
import com.example.jokeschucknorris.mvp.view.ApiWebView
import moxy.MvpAppCompatFragment

class ApiWebViewFragment : MvpAppCompatFragment(), ApiWebView {
    companion object {
        fun newInstance() = ApiWebViewFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_web, null)



    override fun loadApi() {
        TODO("Not yet implemented")
    }

}