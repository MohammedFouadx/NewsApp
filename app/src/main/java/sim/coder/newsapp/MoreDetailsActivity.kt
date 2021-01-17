package sim.coder.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import sim.coder.newsapp.model.NewsData

private lateinit var moreDetailsTitle:TextView
private lateinit var moreDetailsDetails:TextView
private lateinit var moreDetailsDate:TextView
private lateinit var moreDetailsImage:ImageView

class MoreDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_details)


         moreDetailsTitle =findViewById(R.id.more_Details_title)
         moreDetailsDetails =findViewById(R.id.more_Details_details)
         moreDetailsDate =findViewById(R.id.more_Details_date)
        moreDetailsImage=findViewById(R.id.more_Details_ImageView)

        var intent= intent.getSerializableExtra("key") as NewsData


        Picasso.with(this).load(intent.images).into(moreDetailsImage)
        moreDetailsTitle.text=intent.title
        moreDetailsDetails.text=intent.details
        moreDetailsDate.text=intent.date



    }
}