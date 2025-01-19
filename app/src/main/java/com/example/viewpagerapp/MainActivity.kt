package com.example.viewpagerapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var viewPager2: ViewPager2
    lateinit var myAdapter: MyPagerAdapter
    lateinit var tabLayout: TabLayout
    var tabArray = arrayOf("My App" , "Coding","Last Advice")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 1 - Initialize the viewPager
        viewPager2 = findViewById(R.id.viewPager2)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //2 - Add the fragments to the list in Adapter class
        myAdapter = MyPagerAdapter(supportFragmentManager,lifecycle)
        myAdapter.addFragementToList(FragmentOne())
        myAdapter.addFragementToList(FragmentTwo())
        myAdapter.addFragementToList(FragmentThree())

        //3 - Connecting Adapter with viewPager2
        viewPager2.adapter = myAdapter

        //4 - Connecting ViewPager with TabLayout
        tabLayout = findViewById(R.id.tabLayout)
        // it is the androidx library used to with tablaout which helps to use with viewPager as it
        //synchonize automatically and updates layout as changes in the viewPager
        TabLayoutMediator(
            tabLayout,
            viewPager2
            ){
                tab,position ->
                //customizing the tab labels if needed
                tab.text = tabArray[position]
            }.attach()


    }
}