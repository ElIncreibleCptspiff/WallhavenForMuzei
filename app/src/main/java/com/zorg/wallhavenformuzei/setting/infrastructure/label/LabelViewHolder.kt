package com.zorg.wallhavenformuzei.setting.infrastructure.label

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zorg.wallhavenformuzei.databinding.ItemLabelBinding
import com.zorg.wallhavenformuzei.setting.domain.LabelCard

class LabelViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemLabelBinding.bind(view)

    fun render(labelLocalInfoModel: LabelCard) {
        binding.tvLabel.text = labelLocalInfoModel.label
        Glide.with(binding.ivPhoto0).load(labelLocalInfoModel.photo0).into(binding.ivPhoto0)
        Glide.with(binding.ivPhoto1).load(labelLocalInfoModel.photo1).into(binding.ivPhoto1)
        Glide.with(binding.ivPhoto2).load(labelLocalInfoModel.photo2).into(binding.ivPhoto2)
        Glide.with(binding.ivPhoto3).load(labelLocalInfoModel.photo3).into(binding.ivPhoto3)
    }
}