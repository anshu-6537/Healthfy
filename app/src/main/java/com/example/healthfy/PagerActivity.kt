package com.example.healthfy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

class PagerActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler : Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter : ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)

        init()
        SetUpTransformer()


        viewPager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable,2000)
            }
        })
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
        handler.postDelayed(runnable,2000)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable,2000)
    }
    private val runnable= Runnable {
        viewPager2.currentItem=viewPager2.currentItem +1
    }




    private fun SetUpTransformer()
    {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r=-1 - Math.abs(position)
            page.scaleY =.85f + r * 0.14f
            /////////////////////////////////////////////////////////page.
        }
        viewPager2.setPageTransformer(transformer)
    }



    private fun init(){
        viewPager2 = findViewById(R.id.viewPager2)
        handler =Handler(Looper.myLooper()!!)
        imageList= ArrayList()

        imageList.add(R.drawable.tea)
        imageList.add(R.drawable.icecream)
        imageList.add(R.drawable.juice)
        imageList.add(R.drawable.omelette)
        imageList.add(R.drawable.egg)
        imageList.add(R.drawable.salad)
        imageList.add(R.drawable.eggimg)
        imageList.add(R.drawable.eggimg)
        imageList.add(R.drawable.juices)

        adapter = ImageAdapter(imageList,viewPager2)
        viewPager2.adapter=adapter
        viewPager2.offscreenPageLimit=3
        viewPager2.clipToPadding=false
        viewPager2.clipChildren=false
        viewPager2.getChildAt(0).overScrollMode= RecyclerView.OVER_SCROLL_NEVER
    }
}