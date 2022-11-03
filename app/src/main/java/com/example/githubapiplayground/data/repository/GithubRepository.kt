package com.example.githubapiplayground.data.repository

import com.example.githubapiplayground.data.models.ClosedIssuesResponse
import com.example.githubapiplayground.utils.RepoState
import retrofit2.Response

interface GithubRepository {
    suspend fun getClosedIssues(owner:String,repo:String,state: RepoState): Response<ClosedIssuesResponse>
}