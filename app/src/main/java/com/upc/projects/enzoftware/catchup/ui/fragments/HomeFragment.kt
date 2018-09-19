package com.upc.projects.enzoftware.catchup.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.error.ANError

import com.upc.projects.enzoftware.catchup.R
import com.upc.projects.enzoftware.catchup.model.Article
import com.upc.projects.enzoftware.catchup.network.NewsApi
import com.upc.projects.enzoftware.catchup.network.response.ArticlesResponse
import com.upc.projects.enzoftware.catchup.ui.adapters.ArticlesAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    var articles = ArrayList<Article>()
    lateinit var articlesRecyclerView: RecyclerView
    lateinit var articlesAdapter: ArticlesAdapter
    lateinit var articlesLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        articlesAdapter = ArticlesAdapter(articles, view.context)
        articlesLayoutManager = GridLayoutManager(view.context, 2)
        articlesRecyclerView = view.articlesRecyclerView
        articlesRecyclerView.adapter = articlesAdapter
        articlesRecyclerView.layoutManager = articlesLayoutManager

        NewsApi.requestHeadlines(getString(R.string.news_api_key),
                {response ->  handleResponse(response)},
                {anError -> errorHandler(anError) })

        return view
    }

    private fun handleResponse(response: ArticlesResponse?){
        if("error".equals(response!!.status, true)){
            Log.d(NewsApi.tag, response.message)
            return
        }

        articles = response.articles!!
        Log.d(NewsApi.tag, "Parsed: Found ${articles.size} articles")
        articlesAdapter.articles = articles
        articlesAdapter.notifyDataSetChanged()
    }

    private fun errorHandler(anError: ANError?){
        Log.d(tag, anError!!.message)
    }

}
