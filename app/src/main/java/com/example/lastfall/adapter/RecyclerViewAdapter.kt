package com.example.lastfall.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.ListFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lastfall.NoteEntity
import com.example.lastfall.R
import com.example.lastfall.fragments.listfragmentDirections

class RecyclerViewAdapter:RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder>() {
private var notelist = emptyList<NoteEntity>()
    class myViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tv_title = view.findViewById<TextView>(R.id.tvTitle)
        val tv_desc = view.findViewById<TextView>(R.id.tvDesc)
        fun bind(noteEntity: NoteEntity){
            tv_title.setText(noteEntity.title)
            tv_desc.setText(noteEntity.text)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notelist.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentnote = notelist.get(position)
        holder.bind(currentnote)
        holder.itemView.setOnClickListener {
            val action = listfragmentDirections.actionListfragmentToUpdateNote(currentnote)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun SetData(notelist:List<NoteEntity>){
        this.notelist = notelist
        notifyDataSetChanged()
    }

}