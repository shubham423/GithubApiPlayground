package com.example.githubapiplayground.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapiplayground.data.models.Issue
import com.example.githubapiplayground.data.repository.GithubRepository
import com.example.githubapiplayground.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class IssuesViewModel @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {

    private val _issues: MutableLiveData<Resource<List<Issue>>> = MutableLiveData()
    val issues: LiveData<Resource<List<Issue>>> = _issues

    fun getClosedIssues(owner:String,repo:String,state: RepoState) {
        viewModelScope.launch {
            try {
                val result = repository.getClosedIssues(owner,repo,state)
                Timber.d("result ${result.body()}")
                if (result.isSuccessful) {
                    _issues.value = result.body()?.let { Resource.Success(data = it) }
                } else {

                }
            } catch (e: Exception) {
                _issues.value = Resource.Error(message = e.message.toString())
                Timber.d("result exception ${e.message}")
            }


        }
    }
}