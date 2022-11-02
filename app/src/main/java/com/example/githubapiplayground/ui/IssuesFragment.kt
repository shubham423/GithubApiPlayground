package com.example.githubapiplayground.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.githubapiplayground.databinding.FragmentIssuesBinding
import com.example.githubapiplayground.ui.adapter.IssuesAdapter
import com.example.githubapiplayground.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class IssuesFragment : Fragment() {

    private lateinit var binding: FragmentIssuesBinding
    private val viewModel: IssuesViewModel by activityViewModels()
    private lateinit var issuesAdapter:IssuesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssuesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getClosedIssues("shubham423","TOA",RepoState.CLOSED)
        initObservers()
    }

    private fun initObservers() {
        viewModel.issues.observe(viewLifecycleOwner){
            Timber.d("init ${it.data}")
            when(it){
                is Resource.Success -> {
                    binding.progressBar.visibility=View.GONE
                    issuesAdapter= IssuesAdapter(it.data!!)
                    binding.rvIssues.adapter=issuesAdapter

                }
                is Resource.Error -> {
                    binding.progressBar.visibility=View.GONE
                }
                is Resource.Loading -> {
                    binding.progressBar.visibility=View.VISIBLE
                }
            }
        }
    }
}