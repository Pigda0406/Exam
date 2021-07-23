package com.martin.exam.github

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.martin.exam.github.adapter.UsersAdapter
import com.martin.exam.github.databinding.FragmentUsersBinding
import com.martin.exam.github.viewmodels.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UsersFragment : Fragment() {

    private val usersViewModel: UsersViewModel by viewModels()
    private val usersAdapter: UsersAdapter = UsersAdapter()
    private var getUsersJob: Job? = null
    private lateinit var binding: FragmentUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        binding.rvUsers.adapter = usersAdapter
        binding.srUsersSwiperefresh.setOnRefreshListener {
            binding.srUsersSwiperefresh.isRefreshing = true
            getUsers()
        }
        getUsers()
        return binding.root
    }

    private fun getUsers() {
        getUsersJob?.cancel()
        getUsersJob = lifecycleScope.launch {
            usersViewModel.gerUsers().collectLatest {
                binding.srUsersSwiperefresh.isRefreshing = false
                usersAdapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}