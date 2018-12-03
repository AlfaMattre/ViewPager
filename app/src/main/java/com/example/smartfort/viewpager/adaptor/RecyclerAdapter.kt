package com.example.smartfort.viewpager.adaptor

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.smartfort.viewpager.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    private val images = intArrayOf(
        R.drawable.cropped_min,
        R.drawable.jacket_min, R.drawable.long_min,
        R.drawable.red_hoodie_min
    )

    private val titles = arrayOf("cropped_min",
        "jacket_min", "long_min", "red_hoodie_min")

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle: TextView
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
    }
}
}