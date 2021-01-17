package sim.coder.newsapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sim.coder.newsapp.api.NewsApi
import sim.coder.newsapp.api.NewsResponse
import sim.coder.newsapp.model.NewsData

class NewsFetchr {

    private  var  newsApi:NewsApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://172.16.16.253")
                .build()
        newsApi = retrofit.create(NewsApi::class.java)
    }


    fun fetchPolitical(): LiveData<List<NewsData>> {
        val responseLiveData: MutableLiveData<List<NewsData>> = MutableLiveData()
        val newsRequest: Call<NewsResponse> = newsApi.fetchContents(1)
        newsRequest.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("TAG", "Failed to fetch News", t)
            }
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>
            ) {

                val newsResponse:NewsResponse? = response.body()
                val news:List<NewsData> = newsResponse?.newsData
                        ?: mutableListOf()
                Log.d("TAG", "Response received")
                responseLiveData.value = news
                Log.d("onResponse", news.toString())
            }
        })
        return responseLiveData

    }



    fun fetchSport(): LiveData<List<NewsData>> {
        val responseLiveData: MutableLiveData<List<NewsData>> = MutableLiveData()
        val newsRequest: Call<NewsResponse> = newsApi.fetchContents(2)
        newsRequest.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("TAG", "Failed to fetch News", t)
            }
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>
            ) {

                val newsResponse:NewsResponse? = response.body()
                val news:List<NewsData> = newsResponse?.newsData
                        ?: mutableListOf()
                Log.d("TAG", "Response received")
                responseLiveData.value = news
                Log.d("onResponse", news.toString())
            }
        })
        return responseLiveData

    }

    fun fetchOdd(): LiveData<List<NewsData>> {
        val responseLiveData: MutableLiveData<List<NewsData>> = MutableLiveData()
        val newsRequest: Call<NewsResponse> = newsApi.fetchContents(3)
        newsRequest.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("TAG", "Failed to fetch News", t)
            }
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>
            ) {

                val newsResponse:NewsResponse? = response.body()
                val news:List<NewsData> = newsResponse?.newsData
                        ?: mutableListOf()
                Log.d("TAG", "Response received")
                responseLiveData.value = news
                Log.d("onResponse", news.toString())
            }
        })
        return responseLiveData

    }





}