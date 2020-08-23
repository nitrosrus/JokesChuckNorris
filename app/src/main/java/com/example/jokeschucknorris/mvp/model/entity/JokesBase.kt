package com.example.jokeschucknorris.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JokesBase (
    @Expose  val value : List<ValueJoke>
) : Parcelable