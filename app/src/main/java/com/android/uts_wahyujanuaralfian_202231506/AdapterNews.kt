package com.android.uts_wahyujanuaralfian_202231506

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterNews(private val listNews: ArrayList<ListNews>):
    RecyclerView.Adapter<AdapterNews.ListViewHolder>() {
        private lateinit var onItemClickCallback: OnItemClickCallback

        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
            this.onItemClickCallback = onItemClickCallback
        }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_item_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_news, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val move = listNews[position]
        holder.imgPhoto.setImageResource(move.photo)
        holder.tvName.text = move.title
        holder.tvDesc.text = move.desc

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listNews[holder.adapterPosition], holder.adapterPosition)
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: ListNews, position: Int)
    }
}