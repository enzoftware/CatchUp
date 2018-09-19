package com.upc.projects.enzoftware.catchup.network.response

import com.upc.projects.enzoftware.catchup.model.Article

class ArticlesResponse{
    val status: String? = null
    val code: String? = null
    val message:String? = null
    val totalResults:Int? = null
    val articles:ArrayList<Article>? = ArrayList()
}