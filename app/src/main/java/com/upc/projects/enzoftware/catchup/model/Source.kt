package com.upc.projects.enzoftware.catchup.model

import android.os.Bundle
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

    companion object {

        fun from(bundle: Bundle) : Source{
            val source = Source(
                    bundle.getString("id"),
                    bundle.getString("name"),
                    bundle.getString("description"),
                    bundle.getString("url"),
                    bundle.getString("category"),
                    bundle.getString("language"),
                    bundle.getString("country")
            )
            return source
        }



    }

    fun urlToLogo() : String = LogoApi.urlToLogo(url!!)

    fun toBundle() : Bundle {
        val bundle = Bundle()
        with(bundle){
            putString("id",id)
            putString("name",name)
            putString("description",description)
            putString("url",url)
            putString("category",category)
            putString("language",language)
            putString("country",country)
        }

        return bundle
    }
}