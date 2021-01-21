package com.example.hwrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.family_tree_item.view.*

class FamilyAdapter(val family: List<Triple<String, Int, Int>>) : RecyclerView.Adapter<FamilyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.family_tree_item, parent, false)

        return FamilyViewHolder(view)
    }

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        holder.bind(family[position])
    }

    override fun getItemCount(): Int = family.size
}

class FamilyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(triple: Triple<String, Int, Int>){
        itemView.tv_name.text = triple.first
        itemView.tv_age.text = triple.second.toString()


        val scale: Float = itemView.resources.displayMetrics.density
        val dpAsPixels = ((triple.third * 20) * scale + 0.5f).toInt()

        itemView.setPadding(dpAsPixels, 0, 0, 0)
    }
}