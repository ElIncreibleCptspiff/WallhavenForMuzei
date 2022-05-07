package com.zorg.wallhavenformuzei.setting.infrastructure.label

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zorg.wallhavenformuzei.R
import com.zorg.wallhavenformuzei.setting.domain.LabelCard

class LabelAdapter(private val labelLocalInfoList:List<LabelCard>): RecyclerView.Adapter<LabelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabelViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LabelViewHolder(layoutInflater.inflate(R.layout.item_label, parent, false))
    }

    override fun onBindViewHolder(holder: LabelViewHolder, position: Int) {
        val item = labelLocalInfoList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = labelLocalInfoList.size
}