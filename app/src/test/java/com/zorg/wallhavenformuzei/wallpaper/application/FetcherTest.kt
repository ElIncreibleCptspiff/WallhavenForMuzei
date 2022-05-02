package com.zorg.wallhavenformuzei.wallpaper.application

import com.zorg.wallhavenformuzei.core.http.HttpGet
import com.zorg.wallhavenformuzei.wallpaper.domain.WallpaperProvider
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.json.JSONObject
import org.junit.Before

import org.junit.Test

class FetcherTest {

    @RelaxedMockK
    private lateinit var httpGet: HttpGet
    @RelaxedMockK
    private lateinit var wallPaperProvider: WallpaperProvider

    lateinit var fetcher: Fetcher

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        fetcher = Fetcher(httpGet, wallPaperProvider)
    }

    @Test
    fun `Test Provider does not have any item`() {
        //Given
        val jsonObject = JSONObject()
        every { wallPaperProvider.getSearchUrl("label") } returns "url"
        every { httpGet.getJsonFromUrl("url") } returns jsonObject
        //When
        fetcher.fetch("label")
        //Then
        verify(exactly = 1) { wallPaperProvider.getSearchUrl("label") }
        verify(exactly = 1) { wallPaperProvider.deserialize(jsonObject) }
    }
}