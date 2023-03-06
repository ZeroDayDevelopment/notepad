package com.example.lastfall.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lastfall.NoteViewModel
import com.example.lastfall.R
import com.example.lastfall.adapter.RecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class listfragment : Fragment() {

    private lateinit var recyclerViewAdapter:RecyclerViewAdapter
    private lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_listfragment, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {

            findNavController().navigate(R.id.action_listfragment_to_addNote)
        }
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)

        //viewmodel
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        //recyclerview
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = recyclerViewAdapter

        noteViewModel.readAlldata.observe(viewLifecycleOwner, Observer {notelist ->
            recyclerViewAdapter.SetData(notelist)
            if (notelist.size == 0){
                Toast.makeText(context,"Liste boş", Toast.LENGTH_SHORT).show()
            }
        })

        return view
    }

}