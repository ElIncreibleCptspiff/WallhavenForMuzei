package com.zorg.wallhavenformuzei

import android.content.Context
import androidx.work.*
import com.google.android.apps.muzei.api.provider.ProviderContract
import com.zorg.wallhavenformuzei.core.http.HttpGet
import com.zorg.wallhavenformuzei.core.http.HttpGetFactory
import com.zorg.wallhavenformuzei.artwork.Service as artWorkService
import com.zorg.wallhavenformuzei.wallpaper.infrastructure.Service as WallpaperService
import com.zorg.wallhavenformuzei.wallpaper.application.JsonSchemaException
import com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.NoItemsException
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeoutException

class MuzeiWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    companion object {
        internal fun enqueueLoad(context: Context) {
            val workManager = WorkManager.getInstance(context)
            workManager.enqueue(
                OneTimeWorkRequestBuilder<MuzeiWorker>().setConstraints(
                    Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
                ).build()
            )
        }
    }

    override fun doWork(): Result {
        return try {
            val wallpaper = WallpaperService(applicationContext).getFromWallHaven()
            val providerClient = ProviderContract.getProviderClient(applicationContext, ArtProvider::class.java)
            providerClient.addArtwork(artWorkService.create(wallpaper))
            Result.success()
        } catch (e: NoItemsException) {
            Result.retry()
        } catch (e: JsonSchemaException) {
            Result.failure()
        } catch (e: InterruptedException) {
            Result.retry()
        } catch (e: TimeoutException) {
            Result.retry()
        } catch (e: ExecutionException) {
            Result.failure()
        }
    }
}