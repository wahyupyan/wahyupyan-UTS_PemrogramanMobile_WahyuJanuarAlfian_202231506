package com.android.uts_wahyujanuaralfian_202231506

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailBerita : AppCompatActivity() {

    private lateinit var imgDetail: ImageView
    private lateinit var tvDetailTitle: TextView
    private lateinit var tvDetailDesc: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val photo = intent.getIntExtra("photo", 0)

        findViewById<ImageView>(R.id.img_detail).setImageResource(photo)
        findViewById<TextView>(R.id.tv_detail_title).text = title
        findViewById<TextView>(R.id.tv_detail_desc).text = desc
    }
}