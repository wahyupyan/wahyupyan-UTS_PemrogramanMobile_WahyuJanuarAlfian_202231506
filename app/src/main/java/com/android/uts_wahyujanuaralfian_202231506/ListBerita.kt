package com.android.uts_wahyujanuaralfian_202231506

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListBerita : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterNews: AdapterNews
    private val listNews = ArrayList<ListNews>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_berita)

        recyclerView = findViewById(R.id.rc_news)
        recyclerView.setHasFixedSize(true)

        listNews.addAll(getNewsData())
        showRecyclerList()
    }

    private fun getNewsData(): ArrayList<ListNews> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listApps = ArrayList<ListNews>()
        for (i in dataName.indices){
            val apps = ListNews(dataName[i], dataDesc[i], dataPhoto.getResourceId(i, -1))
            listApps.add(apps)
        }
        dataPhoto.recycle()
        return listApps
    }

    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapterNews = AdapterNews(listNews)
        recyclerView.adapter = adapterNews

        adapterNews.setOnItemClickCallback(object : AdapterNews.OnItemClickCallback{
            override fun onItemClicked(data: ListNews, position: Int) {

                val intent = Intent(this@ListBerita, DetailBerita::class.java)
                intent.putExtra("title", data.title)
                intent.putExtra("desc", data.desc)
                intent.putExtra("photo", data.photo)
                startActivity(intent)
            }
        })
    }
}