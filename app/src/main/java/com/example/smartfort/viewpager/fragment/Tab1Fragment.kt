package com.example.smartfort.viewpager.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartfort.viewpager.R
import com.example.smartfort.viewpager.adaptor.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_tab1.view.*

class Tab1Fragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab1, container,  false)

        layoutManager = LinearLayoutManager(context)
        view.recycler_view.layoutManager = layoutManager

        adapter = RecyclerAdapter()

        adapter = RecyclerAdapter()
        view.recycler_view.adapter = adapter

        return view
    }
}
