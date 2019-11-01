package com.example.makeup_best_practices_sprint_challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.makeup_best_practices_sprint_challenge.Model.MakeUpProductData
import kotlinx.android.synthetic.main.activity_main.view.*

class MakeUpAdapter(val makeUpData: List<MakeUpProductData>): RecyclerView.Adapter<MakeUpAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val ratingBar = view.Rating_bar
        val textViewPrice = view.text_view_price
        val textViewName = view.text_view_name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return makeUpData.size
    }

    override fun onBindViewHolder(holder: MakeUpAdapter.ViewHolder, position: Int) {
        holder.ratingBar.numStars = makeUpData[position].rating
        holder.textViewName.text = makeUpData[position].name
        holder.textViewPrice.text = makeUpData[position].price
    }


}