package sim.coder.newsapp.api

import com.google.gson.annotations.SerializedName
import sim.coder.newsapp.model.NewsData

class NewsResponse {

    @SerializedName("getAllRows")
    lateinit var newsData: List<NewsData>

}