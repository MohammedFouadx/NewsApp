package sim.coder.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import sim.coder.newsapp.fragment.NewsAppFragment


lateinit var tabLayout: TabLayout
lateinit var tabViewPager: ViewPager2

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabs)
        tabViewPager = findViewById(R.id.viewPager)



        tabViewPager.adapter  = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {

                return 3
            }

            override fun createFragment(position: Int): Fragment {
                return when (position) {

                    0 -> NewsAppFragment.newInstance("political")
                    1 -> NewsAppFragment.newInstance("sport")
                    2 -> NewsAppFragment.newInstance("odds")


                    else -> NewsAppFragment.newInstance("odds")
                }
            }


        }
        TabLayoutMediator(tabLayout, tabViewPager) {tab, position ->
            tab.text = when (position){
                0 -> "political"
                1 -> "sport"
                2 -> "odds"

                else -> {
                    null
                }
            }


        }.attach()
    }
}

