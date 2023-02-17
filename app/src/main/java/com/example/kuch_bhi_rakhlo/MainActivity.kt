package com.example.kuch_bhi_rakhlo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        load()
    }
    private fun load(){

// ...

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val base_url = "https://android-kotlin-fun-mars-server.appspot.com/"

// Request a string response from the provided URL.
        val JsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, base_url,null,
            { response ->
                val url=response.getString("photos")
                Glide.with(this).load(url).into(imageView12)

                // Display the first 500 characters of the response string.

            },
            Response.ErrorListener{
                Toast.makeText(this, "something went wroong", Toast.LENGTH_SHORT).show()


            })

// Add the request to the RequestQueue.
        queue.add(JsonObjectRequest)
    }
}