package com.main.isteaproject.repository

import com.main.isteaproject.model.Sample
import com.main.isteaproject.network.KtorClient
import io.ktor.client.request.*

object SampleRepository {

    suspend fun getSampleDetail(): Sample {
        return KtorClient.httpClient.use {
            it.get("https://soy-glucosa-project.herokuapp.com/apiFirebase/productosKotlin/") //here is put the method like GET or POST
        }
    }
}