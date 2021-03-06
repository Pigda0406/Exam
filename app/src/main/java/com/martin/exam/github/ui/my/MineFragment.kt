package com.martin.exam.github.ui.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.martin.exam.github.databinding.FragmentMineBinding
import com.martin.exam.github.ui.info.UserInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MineFragment : Fragment() {
    private lateinit var binding: FragmentMineBinding
    private val userInfoViewModel: UserInfoViewModel by viewModels()
    private var getMineInfoJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMineBinding.inflate(inflater, container, false)
        getMineInfo("pigda0406")
        return binding.root
    }

    private fun getMineInfo(id: String) {
        getMineInfoJob?.cancel()
        getMineInfoJob = lifecycleScope.launch {
            userInfoViewModel.getUserInfo(id).collectLatest {
                binding.userInfo = it
                binding.executePendingBindings()
            }
        }
    }
}