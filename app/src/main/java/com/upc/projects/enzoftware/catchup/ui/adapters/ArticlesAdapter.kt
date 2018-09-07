package com.upc.projects.enzoftware.catchup.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.upc.projects.enzoftware.catchup.R
import com.upc.projects.enzoftware.catchup.model.Article
import kotlinx.android.synthetic.main.item_article.view.*

class ArticlesAdapter (val articles:List<Article>, val context: Context):
        RecyclerView.Adapter<ArticlesAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_article, parent, false))
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        TODO("Assing picture image")
        holder.titleTextView.text = article.title
    }


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val pictureImageView = view.pictureImageView!!
        val titleTextView = view.titleTextView!!
    }
}