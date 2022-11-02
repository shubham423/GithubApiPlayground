package com.example.githubapiplayground.data.network

import com.example.githubapiplayground.data.models.ClosedIssuesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/issues")
    suspend fun getClosedIssues(
        @Query("q") query: String
    ):Response<ClosedIssuesResponse>
}