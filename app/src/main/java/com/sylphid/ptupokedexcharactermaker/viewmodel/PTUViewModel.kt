package com.sylphid.ptupokedexcharactermaker.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sylphid.ptupokedexcharactermaker.api.PTURepository
import com.sylphid.ptupokedexcharactermaker.model.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus


const val TAG = "PTUViewModel"
class PTUViewModel(
    private val repository: PTURepository,
    private val dispatcher: CoroutineDispatcher
): ViewModel() {

    private val _abilityListData = MutableLiveData<UIState>()
    val abilityListData: LiveData<UIState> get() = _abilityListData

    private val coroutineExceptionHandler by lazy{
        CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.e(TAG, "Context: ${coroutineContext}\nMessage: ${throwable.localizedMessage}", throwable )
        }
    }

    private val viewModelSafeScope by lazy {
        viewModelScope + coroutineExceptionHandler
    }

    fun getAbilities(){
        viewModelSafeScope.launch(dispatcher) {
            repository.getAbilities().collect(){ state ->
                _abilityListData.postValue(state)
            }
        }
    }

    fun setLoading() {
        _abilityListData.value = UIState.Loading
    }

}