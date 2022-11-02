package com.example.githubapiplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.githubapiplayground.databinding.ActivityMainBinding
import com.example.githubapiplayground.ui.IssuesViewModel
import com.example.githubapiplayground.ui.RepoState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:IssuesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getClosedIssues("shubham423","TOA",RepoState.CLOSED)
    }
}