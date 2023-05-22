package com.zireddinismayilov.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.zireddinismayilov.newsapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        setContentView(binding.root)
        getdata()
    }

    fun getdata() {
        val call: Call<Results> = RetrofitClient.retrofit.getdata()
        call?.enqueue(object : Callback<Results?> {
            override fun onResponse(call: Call<Results?>, response: Response<Results?>) {
                val list: Results = response?.body() as Results
                binding.newsRecyclerView.adapter = Adapter(list)
            }

            override fun onFailure(call: Call<Results?>, t: Throwable) {
                Toast.makeText(applicationContext, "Error has occured!", Toast.LENGTH_SHORT).show()
            }

        })
    }
}