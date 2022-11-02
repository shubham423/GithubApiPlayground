package com.example.githubapiplayground.data.repository

import com.example.githubapiplayground.data.models.ClosedIssuesResponse
import retrofit2.Response

interface GithubRepository {
    suspend fun getClosedIssues(query:String):Response<ClosedIssuesResponse>
}