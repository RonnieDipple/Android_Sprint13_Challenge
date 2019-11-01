package com.example.makeup_best_practices_sprint_challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import com.example.makeup_best_practices_sprint_challenge.Model.MakeUpProductData
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_makeup.view.*


class MakeUpAdapter(val makeUpData: ArrayList<MakeUpProductData>): RecyclerView.Adapter<MakeUpAdapter.ViewHolder>(){

    fun updateMakeup(newMakeUp: List<MakeUpProductData>){
        makeUpData.clear()
        makeUpData.addAll(newMakeUp)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val ratingBar = view.Rating_bar
        val textViewPrice = view.text_view_price
        val textViewName = view.text_view_name

        fun bind(makeUpProductData: MakeUpProductData){
            ratingBar.numStars = makeUpProductData.rating
            textViewPrice.setText(makeUpProductData.price)
            textViewName.setText(makeUpProductData.name)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_makeup, parent, false)

        )

    override fun getItemCount(): Int {
        return makeUpData.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
      holder.bind(makeUpData[position])
    }




}