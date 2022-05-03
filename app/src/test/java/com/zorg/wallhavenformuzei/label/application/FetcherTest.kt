package com.zorg.wallhavenformuzei.label.application

import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.label.domain.LabelProvider
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class FetcherTest {

    @RelaxedMockK
    private lateinit var provider: LabelProvider

    lateinit var fetcher: Fetcher

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        fetcher = Fetcher()
    }

    @Test
    fun `Test if we have 1 label we always return this label`() {
        //Given
        every { provider.getRandom() } returns Label("random")
        //When
        val label = fetcher.getRandom(provider)
        //Then
        verify(exactly = 1) { provider.getRandom() }
        assert(label.title == "random")
    }
}