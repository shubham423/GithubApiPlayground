package com.example.githubapiplayground.data.repository

import com.example.githubapiplayground.data.models.ClosedIssuesResponse
import com.example.githubapiplayground.data.network.GithubApi
import retrofit2.Response
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(val api: GithubApi) : GithubRepository {
    override suspend fun getClosedIssues(query: String): Response<ClosedIssuesResponse> {
        return api.getClosedIssues(query)
    }
}