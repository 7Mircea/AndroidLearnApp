package com.example.myapplication.ui

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.MonstersAdapter


const val TAG = "MainFragment.java"
class MainFragment : Fragment(),MonstersAdapter.OnItemClick {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(context?.applicationContext as Application)
            )[MainViewModel::class.java]

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
        viewModel.monsters.observe(viewLifecycleOwner) {
            recyclerView.adapter = MonstersAdapter(it,this)
            Log.i(TAG, "onViewCreated. it.size${it.size}")
        }


    }

    override fun onMonsterClick() {
        navController.navigate(R.id.detailFragment)
    }

}