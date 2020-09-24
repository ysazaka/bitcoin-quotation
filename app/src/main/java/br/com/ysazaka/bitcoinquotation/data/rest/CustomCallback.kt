package br.com.ysazaka.bitcoinquotation.data.rest

import retrofit2.Response

/**
 * Created by Glauco Sazaka on 23/09/2020.
 */
abstract class CustomCallback<T> {
    abstract fun onSuccess(response: Response<T>)
    abstract fun onFailure(response: Response<T>)
    abstract fun onFailureValidation(response: Response<T>)
}