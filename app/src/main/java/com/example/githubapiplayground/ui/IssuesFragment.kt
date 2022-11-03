package com.example.githubapiplayground.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.githubapiplayground.databinding.FragmentIssuesBinding
import com.example.githubapiplayground.ui.adapter.IssuesAdapter
import com.example.githubapiplayground.utils.RepoState
import com.example.githubapiplayground.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class IssuesFragment : Fragment() {

    private lateinit var binding: FragmentIssuesBinding
    private val viewModel: IssuesViewModel by activityViewModels()
    private lateinit var issuesAdapter: IssuesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssuesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                try {
                    val owner= query?.split("/")?.get(0).toString()
                    val repo= query?.split("/")?.get(1).toString()
                    viewModel.getClosedIssues(owner,repo, RepoState.CLOSED)
                }catch (e:Exception){
                    Toast.makeText(requireContext(), "invalid repo", Toast.LENGTH_SHORT).show()
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun initObservers() {
        viewModel.issues.observe(viewLifecycleOwner) {
            Timber.d("init ${it.data}")
            when (it) {
                is Resource.Success -> {
                    binding.noDataTv.visibility=View.GONE
                    binding.progressBar.visibility = View.GONE
                    issuesAdapter = IssuesAdapter(it.data!!)
                    binding.rvIssues.adapter = issuesAdapter

                }
                is Resource.Error -> {
                    binding.noDataTv.visibility=View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }
}
