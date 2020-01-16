package com.jjonami.retrofitsample

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

// https://api.github.com/repos/[owner_name]/[repositories_name]/contributors

interface RetrofitInterface{
    @GET("repos/{owner}/{repo}/contributors")
    fun requestContributors(
        @Path("owner") owner:String,
        @Path("repo") repo:String
    ) : Single<Array<Contributors>>
}