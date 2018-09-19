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
import com.upc.projects.enzoftware.catchup.model.Source
import com.upc.projects.enzoftware.catchup.network.NewsApi
import com.upc.projects.enzoftware.catchup.network.response.SourceResponse
import com.upc.projects.enzoftware.catchup.ui.adapters.SourcesAdapter
import kotlinx.android.synthetic.main.fragment_sources.view.*


class SourcesFragment : Fragment() {

    var sources: ArrayList<Source> = ArrayList()
    lateinit var sourcesAdapter: SourcesAdapter
    lateinit var sourcesRecyclerView: RecyclerView
    lateinit var sourcesLayoutManager: RecyclerView.LayoutManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sources, container, false)
        sourcesRecyclerView = view.sourcesRecyclerView
        sourcesAdapter = SourcesAdapter(sources, view.context)
        sourcesLayoutManager = GridLayoutManager(view.context, 2)
        sourcesRecyclerView.adapter = sourcesAdapter
        sourcesRecyclerView.layoutManager = sourcesLayoutManager

        NewsApi.requestSources(getString(R.string.news_api_key),
                {response -> handleResponse(response) },
                { error -> handleError(error)}
        )
        return view
    }

    private fun handleResponse(response: SourceResponse?){
        if("error".equals(response!!.status!!)){
            Log.d(NewsApi.tag,response.message)
            return
        }
        sources = response.sources!!
        Log.d(NewsApi.tag, "Found ${sources.size} sources")
        sourcesAdapter.sources = sources
        sourcesAdapter.notifyDataSetChanged()
    }

    private fun handleError(anError: ANError?){
        Log.d(tag,anError!!.message)
    }

}
