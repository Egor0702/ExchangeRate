package com.example.exchangerate.model

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.exchangerate.domain.core.Failure
import com.example.exchangerate.model.activity.BaseActivity

fun <T : Any, L : LiveData<T>> LifecycleOwner.onSuccess(liveData: L?, body: (T?) -> Unit) {
    liveData?.observe(this, Observer(body))
}

fun <L : LiveData<Failure>> LifecycleOwner.onFailure(liveData: L, body: (Failure?) -> Unit) {
    liveData.observe(this, Observer(body))
}
inline fun FragmentActivity?.base (block: BaseActivity.() -> Unit) = (this as? BaseActivity)?.let(block)