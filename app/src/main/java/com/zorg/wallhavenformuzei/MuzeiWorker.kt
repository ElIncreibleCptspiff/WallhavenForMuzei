package com.zorg.wallhavenformuzei

import android.content.Context
import androidx.work.*
import com.google.android.apps.muzei.api.provider.ProviderContract
import com.zorg.wallhavenformuzei.domain.CreateArtWork
import com.zorg.wallhavenformuzei.data.error.NoItemsException
import com.zorg.wallhavenformuzei.ui.viewmodel.WallpaperViewModel
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
            val wallpaper = WallpaperViewModel(applicationContext).getWallpaper()
            val providerClient = ProviderContract.getProviderClient(applicationContext, ArtProvider::class.java)
            providerClient.addArtwork(CreateArtWork.create(wallpaper))
            Result.success()
        } catch (e: NoItemsException) {
            Result.retry()
        } catch (e: InterruptedException) {
            Result.retry()
        } catch (e: TimeoutException) {
            Result.retry()
        } catch (e: ExecutionException) {
            Result.failure()
        }
    }
}