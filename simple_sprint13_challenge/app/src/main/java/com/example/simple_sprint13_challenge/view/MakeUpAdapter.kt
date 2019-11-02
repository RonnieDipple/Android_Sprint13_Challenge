package com.example.simple_sprint13_challenge.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_sprint13_challenge.Model.MakeUpData
import com.example.simple_sprint13_challenge.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_makeup_simple.view.*
//
class MakeUpAdapter(val makeUpDataList: List<MakeUpData>): RecyclerView.Adapter<MakeUpAdapter.ViewHolder>(){
/*
    fun updateMakeup(newMakeUp: List<MakeUpProductData>){
        makeUpDataList.clear()
        makeUpDataList.addAll(newMakeUp)
        notifyDataSetChanged()
    }*/

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageView = view.image_view
        val ratingBar = view.Rating_bar
        val textViewPrice = view.text_view_price
        val textViewBrand = view.text_view_brand

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_makeup_simple, parent, false))

    }

    override fun getItemCount(): Int {
        return makeUpDataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val makeUpData = makeUpDataList[position]
        holder.textViewBrand.setText(makeUpData.brand)
        holder.textViewPrice.setText(makeUpData.price)
        holder.ratingBar.numStars = makeUpData.rating
        Picasso.get().load(makeUpData.image_link).into(holder.imageView)
    }





}