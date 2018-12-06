package com.example.smartfort.viewpager.adaptor

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.smartfort.viewpager.R
import com.example.smartfort.viewpager.activity.ItemActivity

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    lateinit var context: Context

    private val images = intArrayOf(
        R.drawable.cropped_min,
        R.drawable.jacket_min, R.drawable.long_min,
        R.drawable.red_min)

    private val titles = arrayOf("cropped_min",
        "jacket_min", "long_min", "red_min")

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_item, viewGroup, false)
        context = viewGroup.context
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemTitle.text = titles[position]
        viewHolder.itemImage.setImageResource(images[position])
        viewHolder.itemView.setOnClickListener {
            onViewClick(position)
        }
    }

    fun onViewClick(position: Int){
        val intent = Intent(context,ItemActivity::class.java)
        intent.putExtra("text_url", titles[position])
        context.startActivity(intent)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle: TextView
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
        }
    }
}
