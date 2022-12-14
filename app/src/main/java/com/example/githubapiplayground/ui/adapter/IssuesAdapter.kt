package com.example.githubapiplayground.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubapiplayground.data.models.Issue
import com.example.githubapiplayground.databinding.ItemIssueBinding
import com.example.githubapiplayground.utils.convertIntoDate

class IssuesAdapter(val data: List<Issue>) : RecyclerView.Adapter<IssuesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemIssueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(issue: Issue) {
            binding.titleTv.text = issue.title
            binding.closedDateTv.text = issue.closedAt.convertIntoDate()
            binding.openedDateTv.text = issue.createdAt.convertIntoDate()
            Glide.with(binding.root).load(issue.user.avatarUrl).into(binding.userImg)
            binding.usernameTv.text=issue.user.login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemIssueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}