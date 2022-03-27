package com.example.exchangerate.domain.usecase

import android.util.Log
import com.example.exchangerate.domain.core.BusLogic
import com.example.exchangerate.domain.core.Failure
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class UseCase <out T>{
    val backgroundContext: CoroutineContext = Dispatchers.IO
    val foregroundContext: CoroutineContext = Dispatchers.Main
    var parentJob: Job = Job()

    abstract suspend fun run(): BusLogic<Failure, T>

    operator fun invoke(onResult: (BusLogic<Failure, T>) -> Unit = {}) {
        unsubscribe()
        parentJob = Job()

        CoroutineScope(foregroundContext + parentJob).launch {
            val result = withContext(backgroundContext) {
                run()
            }

            onResult(result)
        }
    }

    fun unsubscribe() {
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }

}