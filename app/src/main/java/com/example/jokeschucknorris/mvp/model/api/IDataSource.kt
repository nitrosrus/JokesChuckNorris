package com.example.jokeschucknorris.mvp.model.api


import com.example.jokeschucknorris.mvp.model.entity.JokesBase
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface IDataSource {

    //http://api.icndb.com/jokes/random/3
    @GET("/jokes/random/{count}")
    fun getJokes( @Path("count") count: Int): Single<JokesBase>


}