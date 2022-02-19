package com.zorg.wallhavenformuzei

import android.content.Context
import android.util.Log
import androidx.work.*
import com.google.android.apps.muzei.api.provider.ProviderContract
import com.zorg.wallhavenformuzei.error.NoItemsException
import com.zorg.wallhavenformuzei.service.ArtWork
import com.zorg.wallhavenformuzei.service.Searcher
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class WallhavenWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    companion object {

        internal fun enqueueLoad(context: Context) {
            val workManager = WorkManager.getInstance(context)
            workManager.enqueue(
                OneTimeWorkRequestBuilder<WallhavenWorker>()
                    .setConstraints(
                        Constraints.Builder()
                            .setRequiredNetworkType(NetworkType.CONNECTED)
                            .build()
                    )
                    .build()
            )
        }
    }

    override fun doWork(): Result {
        val future = Searcher.search(applicationContext)
        return try {
            val searchJson = future.get(60, TimeUnit.SECONDS)
            val providerClient = ProviderContract.getProviderClient(applicationContext, WallhavenArtProvider::class.java)
            providerClient.addArtwork(ArtWork.build(searchJson))
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