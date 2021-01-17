package sim.coder.newsapp.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sim.coder.newsapp.MoreDetailsActivity
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

        var newsFetchr= NewsFetchr()
        when (fragmentName){
            "political" -> {
                val newsLiveData=newsFetchr.fetchPolitical()
                newsLiveData.observe(this, Observer {
                    Log.d("political", "Response received: ${it}")
                    newAppRecyclerView.adapter = NewsAdapter(it)
                })
            }
            "sport" -> {

                val newsLiveData=newsFetchr.fetchSport()
                newsLiveData.observe(this, Observer {
                    Log.d("sport", "Response received: ${it}")
                    newAppRecyclerView.adapter = NewsAdapter(it)
                })
            }
            "odds" -> {
                val newsLiveData=newsFetchr.fetchOdd()
                newsLiveData.observe(this, Observer {
                    Log.d("odd", "Response received: ${it}")
                    newAppRecyclerView.adapter = NewsAdapter(it)
                })            }
        }




    }



    private  inner class NewsHolder(view: View) : RecyclerView.ViewHolder(view){

        val listItemCardView = view.findViewById(R.id.cardView) as CardView
        val newsAppImage=view.findViewById(R.id.news_image) as ImageView
        val newsAppTitle=view.findViewById(R.id.news_title) as TextView
        val newsAppDetails=view.findViewById(R.id.news_details) as TextView
        val newsAppDate=view.findViewById(R.id.news_date) as TextView






        fun bind(news: NewsData){

            Picasso.with(context).load(news.images).into(newsAppImage)
            newsAppTitle.text=news.title
            newsAppDetails.text=news.details
            newsAppDate.text=news.date


            listItemCardView.setOnClickListener {
                val intentMoreDetails = Intent(context,MoreDetailsActivity::class.java)
                var bundle = Bundle()
                bundle.putSerializable("key",news)
                intentMoreDetails.putExtras(bundle)
                startActivity(intentMoreDetails)

            }




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
