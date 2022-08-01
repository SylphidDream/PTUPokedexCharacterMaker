package com.sylphid.ptupokedexcharactermaker.api

import com.sylphid.ptupokedexcharactermaker.model.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface PTURepository {
    suspend fun getAbilities(): Flow<UIState>
    //suspend fun getPokemon(): Flow<UIState>
}

class PTURepositoryImpl(private val service: PTUService): PTURepository{
    override suspend fun getAbilities(): Flow<UIState> =
        flow{
            try {
                emit(UIState.Success(service.getAbilities()))
            } catch(e: Exception){
                emit(UIState.Error(e))
            }
        }
}