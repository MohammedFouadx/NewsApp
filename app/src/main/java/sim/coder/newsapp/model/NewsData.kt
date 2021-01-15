package sim.coder.newsapp.model

import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("news_title")
    var title: String = "",

    @SerializedName("news_details")
    var details:String = "",

    @SerializedName("news_images")
    var images:String ="",


    @SerializedName("news_date")
    var date:String ="",


    @SerializedName("cat_title")
    var catTitle:String =""



) {
}