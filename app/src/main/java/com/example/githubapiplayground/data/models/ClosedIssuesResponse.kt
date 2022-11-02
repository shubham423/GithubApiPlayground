package com.example.githubapiplayground.data.models


import com.google.gson.annotations.SerializedName

data class ClosedIssuesResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int
)