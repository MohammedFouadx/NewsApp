package sim.coder.newsapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sim.coder.newsapp.NewsFetchr
import sim.coder.newsapp.R
import sim.coder.newsapp.model.NewsAppViewModel
import sim.coder.newsapp.model.NewsData


private const val TAG = "NewsAppFragment"

private lateinit var newsAppViewModel: NewsAppViewModel
private lateinit var newAppRecyclerView: RecyclerView

class NewsAppFragment : Fragment() {
    private var fragmentName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newsAppViewModel =
                ViewModelProviders.of(this).get(NewsAppViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_news_app, container, false)
        newAppRecyclerView=view.findViewById(R.id.news_app_recyclerView)
        fragmentName=arguments?.getSerializable("data")as String
        newAppRecyclerView.layoutManager= LinearLayoutManager(context)


        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var newsF= NewsFetchr()
        when (fragmentName){
            "political" -> {
                val newsLiveData=newsF.fetchPolitical()
                newsLiveData.observe(this, Observer {
                    Log.d("test", "Response received: ${it}")
                    newAppRecyclerView.adapter = NewsAdapter(it)
                })
            }
            "sport" -> {

                Toast.makeText(context,"sport Fragment", Toast.LENGTH_LONG).show()
            }
            "odds" -> {
                val newsLiveData=newsF.fetchOdd()
                newsLiveData.observe(this, Observer {
                    Log.d("test", "Response received: ${it}")
                    newAppRecyclerView.adapter = NewsAdapter(it)
                })            }
        }




    }



    private  inner class NewsHolder(view: View) : RecyclerView.ViewHolder(view){

        val newsAppImage=view.findViewById(R.id.news_image) as ImageView
        val newsAppTitle=view.findViewById(R.id.news_title) as TextView
        val newsAppDetails=view.findViewById(R.id.news_details) as TextView
        val newsAppDate=view.findViewById(R.id.news_date) as TextView




        var news=NewsData()

        fun bind(news: NewsData){

            Picasso.with(context).load(news.images).into(newsAppImage)
            newsAppTitle.text=news.title
            newsAppDetails.text=news.details
            newsAppDate.text=news.date



        }


    }

    inner class NewsAdapter(var news: List<NewsData>) :
            RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view: View

            view = layoutInflater.inflate(R.layout.list_item_news_app, parent, false)

            return NewsHolder(view)

        }


        override fun getItemCount(): Int {

            return news.size

        }


        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            val news=news[position]
            if(holder is NewsHolder)
                holder.bind(news)


        }
    }



    companion object {
        fun newInstance(data: String): NewsAppFragment {
            val args = Bundle().apply {
                putSerializable("data", data)
            }
            return NewsAppFragment().apply {
                arguments = args
            }
        }
    }}
