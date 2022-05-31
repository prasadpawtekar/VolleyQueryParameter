package com.apolisrises.volleyqueryparameter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.apolisrises.volleyqueryparameter.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var queue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        queue = Volley.newRequestQueue(baseContext)
        binding.rvResult.layoutManager = LinearLayoutManager(baseContext)

        binding.btnSearch.setOnClickListener {
            searchArtist()
        }

    }

    private fun searchArtist() {
        val searchText = binding.etSearchText.text.toString()
        val encodedSearchText = URLEncoder.encode(searchText, "UTF-8")

        val url = "https://itunes.apple.com/search?term=$encodedSearchText"

        // If you want to use GET request, by default it is GET request. No need to specify.
        val request = StringRequest(
            url,
            {
                val gson = Gson()
                val response = gson.fromJson(it, ArtistSearchResponse::class.java)

                if(response.resultCount == 0) {
                    Toast.makeText(baseContext, "No result found", Toast.LENGTH_LONG).show()

                } else {
                    val adapter = ArtistAdapter(response.results)
                    binding.rvResult.adapter = adapter
                }

            },
            {
                Toast.makeText(baseContext, "Error is: $it", Toast.LENGTH_LONG).show()
            }
        )

        queue.add(request)

    }
}