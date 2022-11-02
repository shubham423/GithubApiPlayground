package com.example.githubapiplayground.data.network

import com.example.githubapiplayground.data.models.ClosedIssuesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("repos/{owner}/{repo}/issues")
    suspend fun getClosedIssues(
      @Path("owner") owner:String,
      @Path("repo") repo:String,
      @Query("state") state:String
    ):Response<ClosedIssuesResponse>
}