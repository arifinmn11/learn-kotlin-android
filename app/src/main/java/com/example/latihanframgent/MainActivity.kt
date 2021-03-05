package com.example.latihanframgent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.latihanframgent.data.WeatherResponse
import com.example.latihanframgent.weatherapi.WeatherApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            getCurrentData()
        }
    }

    fun getCurrentData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(WeatherApi::class.java)
        val call = service.getCurrentData(lat, lon, token)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if(response.isSuccessful) {
                    val weatherResponse = response.body()!!
                    Log.d("DATAWEATHER", "${weatherResponse}")
                } else {
                    Log.d("DATA FAILURE", "${response.body()}")
                }
            }
        })
    }

    companion object {
        const val baseUrl = "http://api.openweathermap.org/"
        const val token = "81838664961af0f70ac83f72f4e115b2"
        const val lat = -6.2
        const val lon = 106.8166
    }

}
