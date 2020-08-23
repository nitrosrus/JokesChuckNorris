package com.example.jokeschucknorris.ui


import com.example.jokeschucknorris.ui.fragments.JokesFragment

import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class JokesScreen : SupportAppScreen() {

        override fun getFragment() = JokesFragment.newInstance()
    }

    class webScreen : SupportAppScreen() {
       // override fun getFragment()= WebApiFragment.newInstance()


    }

}