package com.example.lastfall.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lastfall.NoteEntity
import com.example.lastfall.NoteViewModel
import com.example.lastfall.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UpdateNote : Fragment() {

    private val args by navArgs<UpdateNoteArgs>()
    private lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_update_note, container, false)
        val et_title = view.findViewById<EditText>(R.id.et_title)
        val et_desc = view.findViewById<EditText>(R.id.et_desc)
        val btn_save = view.findViewById<FloatingActionButton>(R.id.fab_save)

        et_title.setText(args.UpdateNote.title)
        et_desc.setText(args.UpdateNote.text)
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        btn_save.setOnClickListener {
            val updatenote = NoteEntity(args.UpdateNote.id,et_title.text.toString(),et_desc.text.toString())
            viewModel.updateNote(updatenote)
            findNavController().navigate(R.id.action_updateNote_to_listfragment)
        }
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            val alertbuilder = AlertDialog.Builder(requireContext())
            alertbuilder.setMessage("${args.UpdateNote.title} notunu silmek istediğinize emin misiniz?")
            alertbuilder.setTitle("Not silinecek.")
            alertbuilder.setPositiveButton("Evet"){_,_ ->
                viewModel.deleteNote(args.UpdateNote)
                Toast.makeText(requireContext(),"Not silindi.", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_updateNote_to_listfragment)
            }
            alertbuilder.setNegativeButton("Hayır"){_,_ ->

            }
            alertbuilder.create().show()
        }

        return super.onOptionsItemSelected(item)
    }

}