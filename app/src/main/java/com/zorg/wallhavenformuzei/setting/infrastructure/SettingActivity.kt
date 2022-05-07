package com.zorg.wallhavenformuzei.setting.infrastructure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zorg.wallhavenformuzei.core.http.HttpGetFactory
import com.zorg.wallhavenformuzei.databinding.ActivitySettingBinding
import com.zorg.wallhavenformuzei.wallpaper.application.Fetcher as WallpaperFetcher
import com.zorg.wallhavenformuzei.label.infrastructure.Service
import com.zorg.wallhavenformuzei.setting.application.LabelCardCreator
import com.zorg.wallhavenformuzei.setting.domain.LabelCard
import com.zorg.wallhavenformuzei.setting.infrastructure.label.LabelAdapter
import com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.Wallhaven


class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvLabel.layoutManager = LinearLayoutManager(this)
        binding.rvLabel.adapter = LabelAdapter(this.getLabelCards())
    }

    private fun getLabelCards(): List<LabelCard> {
        val wallhavenFetcher = WallpaperFetcher(HttpGetFactory(applicationContext).get(), Wallhaven())
        return LabelCardCreator().CreateList(Service().getAll(), wallhavenFetcher)
    }
}