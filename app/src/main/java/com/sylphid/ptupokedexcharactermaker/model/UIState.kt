package com.sylphid.ptupokedexcharactermaker.model

import java.lang.Exception

sealed class UIState{
    object Loading: UIState()
    class Error(val error: Exception): UIState()
    class Success<T>(val response: T): UIState()
}
