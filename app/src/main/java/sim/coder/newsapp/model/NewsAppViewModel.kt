package sim.coder.newsapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import sim.coder.newsapp.NewsFetchr

class NewsAppViewModel :ViewModel() {


    val newsLiveData: LiveData<List<NewsData>>

    init {
        newsLiveData = NewsFetchr().fetchPolitical()

    }

}