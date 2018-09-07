package com.upc.projects.enzoftware.catchup.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.upc.projects.enzoftware.catchup.R
import com.upc.projects.enzoftware.catchup.model.Source
import kotlinx.android.synthetic.main.item_source.view.*

class SourcesAdapter(val sources: List<Source>, val context: Context): RecyclerView.Adapter<SourcesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_source, parent, false))
    }

    override fun getItemCount(): Int = sources.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val source = sources.get(position)
        TODO("Assing logo image")
        holder.nameTextView.text = source.name
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val logoImageView = view.logoImageView!!
        val nameTextView = view.nameTextView!!
    }
}