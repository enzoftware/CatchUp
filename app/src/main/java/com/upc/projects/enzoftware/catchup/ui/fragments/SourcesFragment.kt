package com.upc.projects.enzoftware.catchup.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.upc.projects.enzoftware.catchup.R
import com.upc.projects.enzoftware.catchup.model.Source
import com.upc.projects.enzoftware.catchup.ui.adapters.SourcesAdapter
import kotlinx.android.synthetic.main.fragment_sources.view.*


class SourcesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sources, container, false)
        val sourcesRecyclerView = view.sourcesRecyclerView
        val sourcesAdapter = SourcesAdapter(ArrayList<Source>(), view.context)
        val sourcesLayoutManager = GridLayoutManager(view.context, 2)
        sourcesRecyclerView.adapter = sourcesAdapter
        sourcesRecyclerView.layoutManager = sourcesLayoutManager
        return view
    }

}
