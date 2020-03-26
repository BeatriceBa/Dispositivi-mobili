package com.example.dispositivimobili

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class AppActivity : AppCompatActivity() {

    private lateinit var homeBtn:ImageButton
    private lateinit var notiBtn:ImageButton
    private lateinit var searchBtn:ImageButton
    private lateinit var profileBtn:ImageButton

    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerViewAdapter: PagerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity)

        // init views
        mViewPager = findViewById(R.id.mViewPager)
        homeBtn = findViewById(R.id.homeBtn)
        profileBtn = findViewById(R.id.profileBtn)
        searchBtn = findViewById(R.id.searchBtn)
        notiBtn = findViewById(R.id.notiBtn)

        //onclick listner
        homeBtn.setOnClickListener {
            mViewPager.currentItem = 0
        }

        searchBtn.setOnClickListener {
            mViewPager.currentItem = 1
        }

        notiBtn.setOnClickListener {
            mViewPager.currentItem = 2
        }

        profileBtn.setOnClickListener {
            mViewPager.currentItem = 3
        }

        mPagerViewAdapter = PagerViewAdapter(supportFragmentManager)
        mViewPager.adapter = mPagerViewAdapter
        mViewPager.offscreenPageLimit = 4

        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                changeTabs(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        mViewPager.currentItem = 0
        homeBtn.setImageResource(R.drawable.ic_home_pink)


    }

    private fun changeTabs(position: Int) {

        if (position == 0) {
            homeBtn.setImageResource(R.drawable.ic_home_pink)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)
        }

        if (position == 1) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_pink)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)
        }

        if (position == 2) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_fill)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)
        }

        if (position == 3) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_pink_fill)
        }

    }
}



