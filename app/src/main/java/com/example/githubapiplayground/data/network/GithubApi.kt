package com.example.githubapiplayground.data.network

import com.example.githubapiplayground.data.models.ClosedIssuesResponse
import retrofit2.Response
import retrofit2.http.GET

interface GithubApi {

    @GET("search")
    suspend fun getClosedIssues():Response<ClosedIssuesResponse>
}