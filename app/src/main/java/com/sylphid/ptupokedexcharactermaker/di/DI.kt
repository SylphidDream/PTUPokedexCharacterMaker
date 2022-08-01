package com.sylphid.ptupokedexcharactermaker.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.sylphid.ptupokedexcharactermaker.api.PTURepositoryImpl
import com.sylphid.ptupokedexcharactermaker.api.PTUService
import com.sylphid.ptupokedexcharactermaker.viewmodel.PTUViewModel
import kotlinx.coroutines.Dispatchers

object DI {

    private val service = PTUService()


    private fun provideRepository() = PTURepositoryImpl(service)
    private fun provideDispatcher() = Dispatchers.IO

    fun provideViewModel(storeOwner: ViewModelStoreOwner): PTUViewModel {
        return ViewModelProvider(storeOwner, object: ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PTUViewModel(provideRepository(), provideDispatcher()) as T
            }
        })[PTUViewModel::class.java]
    }
}