package com.example.myapplication.ui

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.MonstersAdapter
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.model.Monster


const val TAG = "MainFragment.java"

class MainFragment : Fragment(), MonstersAdapter.OnItemClick {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var navController: NavController
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        viewModel =
//            ViewModelProvider(
//                this,
//                ViewModelProvider.AndroidViewModelFactory.getInstance(context?.applicationContext as Application)
//            )[MainViewModel::class.java]
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
        viewModel.monsters.observe(viewLifecycleOwner) {
            binding.recyclerView.adapter = MonstersAdapter(it, this)
            Log.i(TAG, "onViewCreated. it.size${it.size}")
        }

    }

    override fun onMonsterClick(monster: Monster) {
        viewModel.selectedMonster.value = monster
        Log.i(TAG, "onMonsterClick: monster: $monster")
        navController.navigate(R.id.detailFragment)
    }

}