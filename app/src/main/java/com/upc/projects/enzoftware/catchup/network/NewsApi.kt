package com.upc.projects.enzoftware.catchup.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.upc.projects.enzoftware.catchup.network.response.ArticlesResponse
import com.upc.projects.enzoftware.catchup.network.response.SourceResponse

class NewsApi{
    companion object {
        val baseUrl = "https://newsapi.org"
        val topHeadlinesUrl = "$baseUrl/v2/top-headlines"
        val everythingUrl = "$baseUrl/v2/everything"
        val sourcesUrl = "$baseUrl/v2/sources"
        val tag = "CatchUp"

        fun requestHeadlines(key : String, responseHandler : (ArticlesResponse?) -> Unit, errorHandler:(ANError?) -> Unit ) {
            AndroidNetworking.get(NewsApi.topHeadlinesUrl)
                    .addQueryParameter("apiKey",key)
                    .addQueryParameter("country","us")
                    .setPriority(Priority.IMMEDIATE)
                    .setTag(tag)
                    .build()
                    .getAsObject(ArticlesResponse::class.java, object : ParsedRequestListener<ArticlesResponse>{
                        override fun onResponse(response: ArticlesResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }
                    })

        }


        fun requestSources(key: String, responseHandler: (SourceResponse?) -> Unit, errorHandler: (ANError?) -> Unit){
            AndroidNetworking.get(NewsApi.sourcesUrl)
                    .addQueryParameter("apiKey",key)
                    .setPriority(Priority.IMMEDIATE)
                    .setTag(tag)
                    .build()
                    .getAsObject(SourceResponse::class.java, object : ParsedRequestListener<SourceResponse>{
                        override fun onResponse(response: SourceResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }
                    })
        }
    }
}