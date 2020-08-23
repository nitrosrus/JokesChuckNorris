package com.example.jokeschucknorris.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.jokeschucknorris.App
import com.example.jokeschucknorris.R
import com.example.jokeschucknorris.mvp.presenter.MainPresenter
import com.example.jokeschucknorris.mvp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), MainView {

    val navigator = SupportAppNavigator(this, R.id.container)

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_joke_fragment.setOnClickListener({ buttonJoke() })
        btn_web_fragment.setOnClickListener({ buttonWeb() })

    }

    @ProvidePresenter
    fun providePresenter() = MainPresenter(App.instance.router)

    override fun init() {

    }

    override fun buttonJoke() {
        presenter.goToJoke()
        btn_joke_fragment.setImageResource(R.drawable.ic_buffoon_on)
        btn_web_fragment.setImageResource(R.drawable.ic_web_off)
        supportActionBar.let { t -> setTitle(R.string.app_name) }

    }

    override fun buttonWeb() {
        presenter.goToWeb()
        btn_joke_fragment.setImageResource(R.drawable.ic_buffoon_off)
        btn_web_fragment.setImageResource(R.drawable.ic_web_on)
        supportActionBar.let { t -> setTitle("Api info") }
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }


    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }


}


