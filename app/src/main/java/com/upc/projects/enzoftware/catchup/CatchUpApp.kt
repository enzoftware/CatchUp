package com.upc.projects.enzoftware.catchup

import android.app.Application
import com.androidnetworking.AndroidNetworking

class CatchUpApp : Application(){
    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
    }
}