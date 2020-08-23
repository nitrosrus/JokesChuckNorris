package com.example.jokeschucknorris.ui.fragments

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.jokeschucknorris.R
import com.example.jokeschucknorris.mvp.presenter.ApiWebPresenter
import com.example.jokeschucknorris.mvp.view.ApiWebView
import kotlinx.android.synthetic.main.fragment_web.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class ApiWebViewFragment : MvpAppCompatFragment(), ApiWebView {
    companion object {
        fun newInstance() = ApiWebViewFragment()
    }

    @InjectPresenter
    lateinit var presenter: ApiWebPresenter

    val url = "http://www.icndb.com/api/"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_web, null)


    override fun loadApi() {

        val settings = webApi.settings;
        settings.javaScriptEnabled = true
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = true
        settings.blockNetworkImage = false
        settings.loadsImagesAutomatically = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.safeBrowsingEnabled = true  // api 26
        }

        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            settings.mediaPlaybackRequiresUserGesture = false
        }
        settings.domStorageEnabled = true
        settings.setSupportMultipleWindows(true)
        settings.loadWithOverviewMode = true
        settings.allowContentAccess = true
        settings.setGeolocationEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            settings.allowUniversalAccessFromFileURLs = true
        }
        settings.allowFileAccess = true
        webApi.fitsSystemWindows = true
        webApi.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webApi.loadUrl(url)
        webApi.webViewClient = object : WebViewClient() {
        }
    }
}

