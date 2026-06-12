package com.example.putriapps.Note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.putriapps.Message.MessageAdapter
import com.example.putriapps.R
import com.example.putriapps.databinding.FragmentMoreBinding
import com.example.putriapps.databinding.FragmentNote2Binding
import com.example.putriapps.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {

    private var _binding: FragmentNote2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNote2Binding.inflate(inflater, container, false)
        return binding.root

        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Note"
        }
    }

}