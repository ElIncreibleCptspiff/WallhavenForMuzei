package com.zorg.wallhavenformuzei.setting.infrastructure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.zorg.wallhavenformuzei.core.http.HttpGetFactory
import com.zorg.wallhavenformuzei.databinding.ActivitySettingBinding
import com.zorg.wallhavenformuzei.wallpaper.application.Fetcher as WallpaperFetcher
import com.zorg.wallhavenformuzei.label.infrastructure.Service
import com.zorg.wallhavenformuzei.setting.application.LabelCardCreator
import com.zorg.wallhavenformuzei.setting.domain.LabelCard
import com.zorg.wallhavenformuzei.setting.infrastructure.label.LabelAdapter
import com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.wallhaven.Wallhaven
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding
    private val labelCard = mutableListOf<LabelCard>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        loadLabelCards()
    }

    private fun initRecyclerView() {
        binding.rvLabel.layoutManager = LinearLayoutManager(this)
        binding.rvLabel.adapter = LabelAdapter(labelCard)
    }

    private fun loadLabelCards() {
        CoroutineScope(Dispatchers.IO).launch {
            val wallhavenFetcher = WallpaperFetcher(Wallhaven())
            val labelCards = LabelCardCreator().CreateList(Service().getAll(), wallhavenFetcher)
            runOnUiThread {
                labelCard.clear()
                labelCard.addAll(labelCards)
                binding.rvLabel.adapter?.notifyDataSetChanged()
            }
        }
    }
}