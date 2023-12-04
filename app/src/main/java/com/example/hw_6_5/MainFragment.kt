package com.example.hw_6_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.hw_6_5.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel:LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        Glide.with(binding.loveImage).load("https://www.logos.com/grow/wp-content/uploads/2023/02/WxW-Love.png").into(binding.loveImage)
    }

    private fun initClickers() {
        with(binding){
            btnCalculate.setOnClickListener{
                viewModel.getLiveLoveData(etFirst.text.toString(), etSecond.text.toString())
                    .observe(viewLifecycleOwner, Observer {
                        tvResult.text = it.percentage
                        App.appDatabase.getDao().insert(it)
                    })
            }
            btnHistory.setOnClickListener{
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }
}