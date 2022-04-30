package com.sample.core.data.mapper

import com.sample.core.data.network.models.BaseResponse
import com.sample.core.data.network.result.Result
import com.sample.core.data.network.result.asFailure
import com.sample.core.data.network.result.asSuccess
import com.sample.core.data.network.result.isSuccess

interface Mapper<Source, Target> {
    fun map(src: Source): Target
}

abstract class ResultMapper<Source, Target> : Mapper<Result<BaseResponse<Source>>, Result<Target>> {

    protected abstract fun mapSuccessResult(src: Source): Target

    override fun map(src: Result<BaseResponse<Source>>): Result<Target> {
        return if (src.isSuccess()) {
            Result.Success.Value(mapSuccessResult(src.asSuccess().value.data))
        } else {
            Result.Failure.Error(src.asFailure().error)
        }
    }
}