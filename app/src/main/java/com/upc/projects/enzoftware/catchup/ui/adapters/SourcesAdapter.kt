package com.upc.projects.enzoftware.catchup.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.upc.projects.enzoftware.catchup.R
import com.upc.projects.enzoftware.catchup.model.Source
import kotlinx.android.synthetic.main.item_source.view.*

class SourcesAdapter(var sources: List<Source>, val context: Context): RecyclerView.Adapter<SourcesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_source, parent, false))
    }

    override fun getItemCount(): Int = sources.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val source = sources[position]
        holder.updateFrom(source)
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val logoImageView = view.logoImageView!!
        val nameTextView = view.nameTextView!!

        fun updateFrom(source: Source){
            logoImageView.setDefaultImageResId(R.mipmap.ic_launcher)
            logoImageView.setErrorImageResId(R.mipmap.ic_launcher)
            logoImageView.setImageUrl(source.urlToLogo())
            Log.d("CatchUp", source.urlToLogo())
            nameTextView.text = source.name
        }
    }
}