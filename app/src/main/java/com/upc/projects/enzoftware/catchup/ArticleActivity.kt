package com.upc.projects.enzoftware.catchup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.upc.projects.enzoftware.catchup.model.Article
import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.content_article.*

class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent?:return
        val article = Article.fromBundle(intent.extras)
        with(pictureImageViewArticle){
            setDefaultImageResId(R.mipmap.ic_launcher_round)
            setErrorImageResId(R.mipmap.ic_launcher)
            setImageUrl(article.url)
        }

        titleTextViewArticle.text = article.title
        descriptionTextViewArticle.text = article.description
        contentTextViewArticle.text = article.content
    }

}
