package com.example.githubapiplayground.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapiplayground.data.models.Issues
import com.example.githubapiplayground.data.repository.GithubRepository
import com.example.githubapiplayground.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IssuesViewModel @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {

    private val _issues: MutableLiveData<Resource<List<Issues>>> = MutableLiveData()
    val issues: LiveData<Resource<List<Issues>>> = _issues

    fun getClosedIssues(query: String) {
        viewModelScope.launch {
            try {
                val result = repository.getClosedIssues(query)
                if (result.isSuccessful) {
                    _issues.value = result.body()?.let { Resource.Success(it.issues) }
                } else {

                }
            } catch (e: Exception) {
                _issues.value = Resource.Error(message = e.message.toString())
            }


        }
    }
}