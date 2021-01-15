package sim.coder.newsapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/RwadCodingAcademy/NewsApp/api/news_api.php")
    fun fetchContents(@Query("id") id:Int): Call<NewsResponse>

}