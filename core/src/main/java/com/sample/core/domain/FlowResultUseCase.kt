package com.sample.core.domain

import com.sample.core.data.network.result.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class FlowResultUseCase<T> {

    operator fun invoke(): Flow<Result<T>> = flow {
        emit(retrieveData())
    }

    abstract suspend fun retrieveData(): Result<T>
}

abstract class FlowResultWithParamsUseCase<Param, T> {

    operator fun invoke(param: Param): Flow<Result<T>> = flow {
        emit(retrieveData(param))
    }

    abstract suspend fun retrieveData(param: Param): Result<T>
}