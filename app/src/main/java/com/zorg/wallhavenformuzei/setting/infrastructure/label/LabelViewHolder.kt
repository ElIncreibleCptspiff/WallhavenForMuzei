package com.zorg.wallhavenformuzei.setting.infrastructure.label

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zorg.wallhavenformuzei.databinding.ItemLabelBinding
import com.zorg.wallhavenformuzei.setting.domain.LabelCard

class LabelViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemLabelBinding.bind(view)

    fun render(labelLocalInfoModel: LabelCard) {
        binding.tvLabel.text = labelLocalInfoModel.label
        renderImage(binding.ivPhoto0, labelLocalInfoModel.photo0)
        renderImage(binding.ivPhoto1, labelLocalInfoModel.photo1)
        renderImage(binding.ivPhoto2, labelLocalInfoModel.photo2)
        renderImage(binding.ivPhoto3, labelLocalInfoModel.photo3)
    }

    fun renderImage(imageView: ImageView, url: String) {
        if (url.isNotEmpty()) {
            Glide.with(imageView).load(url).into(imageView)
        }
    }
}