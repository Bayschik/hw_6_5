package com.example.hw_6_5.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw_6_5.R
import com.example.hw_6_5.databinding.ItemOnBoardingBinding
import com.example.hw_6_5.onBoarding.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val list = arrayListOf(
        OnBoarding(
            "Have a good time",
            "You should take the time to help those \n who need you",
            R.raw.couple
        ),
        OnBoarding(
            "Cherishing love",
            "It is no longer possible for \n you to cherish love",
            R.raw.couple2
        ),
        OnBoarding(
            "Have a breakup?",
            "We have the correction for you \n don't worry \n Maybe someone is waiting for you!",
            R.raw.couple3
        ),
        OnBoarding(
            "It's fun and many more!",
            "",
            R.raw.couple4
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc
            binding.btnGetStarted.isVisible = adapterPosition == list.lastIndex

            onBoarding.image?.let {
                binding.lottieView.setAnimation(onBoarding.image)
                binding.lottieView.playAnimation()
            }

            binding.btnGetStarted.setOnClickListener { onClick() }
        }
    }
}
