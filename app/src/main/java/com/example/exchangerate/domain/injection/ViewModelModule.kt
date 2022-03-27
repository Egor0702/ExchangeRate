package com.example.exchangerate.domain.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.exchangerate.model.viewmodel.ViewModelFactory
import com.example.exchangerate.model.viewmodel.ViewModelPopular
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelPopular::class)
    abstract fun bindAccountViewModel(accountViewModel: ViewModelPopular): ViewModel
}