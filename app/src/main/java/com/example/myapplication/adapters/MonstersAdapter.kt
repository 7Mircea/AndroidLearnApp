package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Monster

class MonstersAdapter(private val monsters:List<Monster>,private val onClick: OnItemClick) : RecyclerView.Adapter<MonstersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_view_item,parent,false)
        return MyViewHolder(view);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = monsters[position].monsterName
        with(holder) {
            holder.itemView.setOnClickListener {
                onClick.onMonsterClick(monsters[position])
            }
        }
    }

    override fun getItemCount(): Int = monsters.size


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView = view.findViewById(R.id.monsterName);
    }

    interface OnItemClick {
        fun onMonsterClick(monster:Monster)
    }
}