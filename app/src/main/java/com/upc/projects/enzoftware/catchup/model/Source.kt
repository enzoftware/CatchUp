package com.upc.projects.enzoftware.catchup.model

import com.upc.projects.enzoftware.catchup.network.LogoApi

data class Source(val id : String,
                  val name : String,
                  val description : String? = "",
                  val url : String? = "",
                  val category: String? = "",
                  val language: String? = "",
                  val country : String? = ""
                  )
{
    fun urlToLogo() : String = LogoApi.urlToLogo(url!!)
}