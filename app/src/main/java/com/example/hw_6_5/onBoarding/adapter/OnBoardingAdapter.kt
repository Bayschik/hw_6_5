package com.example.hw_6_5.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hw_6_5.databinding.ItemOnBoardingBinding
import com.example.hw_6_5.onBoarding.OnBoarding

class OnBoardingAdapter(private val onClick:() -> Unit):Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){
    private val list = arrayListOf(
        OnBoarding("Have a good time", "You should take the time to help those \n who need you", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgE6QoQC7Hc9js8DtxkY27qHnv_2omWLIgZ-7GC-ghfW8MUci-"),
        OnBoarding("Cherishing love", "It is no longer possible for \n you to cherish love", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTNtudgVCqkzYtUGcYCu9LtfpCZ2fhX3vMhHzsG-mUn4D08dtX8"),
        OnBoarding("Have a breakup?", "We have the correction for you \n don't worry \n Maybe someone is waiting for you!", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcT0gE44Kf6bCurYyugv_8ZA3EnPK--Lh5-ZCAkADTDWDvBjh4Qy"),
        OnBoarding("It's fun and many more!", "", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBcI_7c-nPygPkU2jiq9Sn00DyFkxy5rtBCbGxhec4y7-UOJgx")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding):ViewHolder(binding.root){
        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc
            binding.btnGetStarted.isVisible = adapterPosition == list.lastIndex
            Glide.with(binding.ivBoard).load(onBoarding.image).into(binding.ivBoard)
            binding.btnGetStarted.setOnClickListener{onClick()}
        }

    }

}
