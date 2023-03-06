package com.example.lastfall.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lastfall.NoteEntity
import com.example.lastfall.NoteViewModel
import com.example.lastfall.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddNote : Fragment() {

    private lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_note, container, false)
        val fab_add = view.findViewById<FloatingActionButton>(R.id.fab_add)
        val et_title = view.findViewById<EditText>(R.id.et_title)
        val et_desc = view.findViewById<EditText>(R.id.et_desc)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        fab_add.setOnClickListener {
            val note:NoteEntity = NoteEntity(0,et_title.text.toString(),et_desc.text.toString())
            noteViewModel.addNote(note)
            Toast.makeText(requireContext(),"Listeye eklendi.",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addNote_to_listfragment)
        }
        return view
    }

}