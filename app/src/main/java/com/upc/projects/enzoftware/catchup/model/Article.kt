package com.upc.projects.enzoftware.catchup.model

import android.os.Bundle

data class Article (val source: Source,
                    val author:String? = "",
                    val title:String? = "",
                    val description:String? = "",
                    val content : String? = "",
                    val url:String? = "" ,
                    val urlToImage:String? = "",
                    val publishedAt:String? = ""){


    companion object {

        fun fromBundle(bundle: Bundle) : Article{
            val article = Article(
                    Source.from(bundle.getBundle("source")),
                    bundle.getString("author"),
                    bundle.getString("title"),
                    bundle.getString("description"),
                    bundle.getString("content"),
                    bundle.getString("url"),
                    bundle.getString("urlToImage"),
                    bundle.getString("publishedAt")
            )
            return article
        }

    }


    fun toBundle() :  Bundle {
        val bundle = Bundle()

        with(bundle){
            putBundle("source",source.toBundle())
            putString("author",author)
            putString("title",title)
            putString("description", description)
            putString("content",content)
            putString("url",url)
            putString("urlToImage",urlToImage)
            putString("publishedAt",publishedAt)
        }
        return bundle
    }

}