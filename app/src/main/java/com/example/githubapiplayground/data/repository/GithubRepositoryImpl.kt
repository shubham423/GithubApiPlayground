package com.example.githubapiplayground.data.repository

import com.example.githubapiplayground.data.models.ClosedIssuesResponse
import com.example.githubapiplayground.data.network.GithubApi
import com.example.githubapiplayground.ui.RepoState
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val api: GithubApi) : GithubRepository {

    override suspend fun getClosedIssues(
        owner: String,
        repo: String,
        state: RepoState
    ): Response<ClosedIssuesResponse> {
        return api.getClosedIssues(owner, repo, state = state.name.lowercase(Locale.ROOT))
    }
}