package com.example.myapplication.ui.fragments.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentContactBinding


/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {

    private var binding: FragmentContactBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentContactBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        this.binding = binding
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.toMapsContact?.setOnClickListener { _ ->
            findNavController().navigate(R.id.mapsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}