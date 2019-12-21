package com.jca.connectivity

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val conn = ConnectionLiveData(this)

        conn.observe(this, Observer {
            if (it) {
                connected()
            } else {
                disconnected()
            }
        })

    }

    private fun disconnected() {
        textlayout.visibility = View.INVISIBLE
        imagelayout.visibility = View.VISIBLE
    }

    private fun connected() {
        textlayout.visibility = View.VISIBLE
        imagelayout.visibility = View.INVISIBLE
        fetchFeeds()
    }

    private fun fetchFeeds() {
        //some delay
        Handler().postDelayed({
            textlayout.text = "Data from the server"
        }, 3000)

    }

}

