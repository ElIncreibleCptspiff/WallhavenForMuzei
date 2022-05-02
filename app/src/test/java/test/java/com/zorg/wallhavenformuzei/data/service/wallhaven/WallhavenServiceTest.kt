package test.java.com.zorg.wallhavenformuzei.data.service.wallhaven

import com.zorg.wallhavenformuzei.core.http.HttpGet
import com.zorg.wallhavenformuzei.data.service.wallpaper.wallhaven.Service
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.json.JSONObject
import org.junit.Before
import org.junit.Test

class WallhavenServiceTest {

    @RelaxedMockK
    private lateinit var httpGet: HttpGet

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `TEst 1`() {
        //Given
        every { httpGet.getJsonFromUrl(any()) } returns JSONObject()
        //When
        Service(httpGet).getRandomWallpaper()
        //Then
        verify(exactly = 1) { httpGet.get(any()) }
    }
}