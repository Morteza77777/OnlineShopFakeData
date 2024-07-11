package com.example.exam.remote.others

import com.example.exam.remote.dataModel.ErrorModel
import com.google.gson.Gson
import retrofit2.Response

object ErrorHandler {

    fun getError (response: Response<*>):String{

        var error : String? = null
        val body = response.errorBody()
        if (body!=null)
            error =Gson().fromJson(body.string(),ErrorModel::class.java).message



        return error ?: "ارتباط برقرار نشد"
    }
}