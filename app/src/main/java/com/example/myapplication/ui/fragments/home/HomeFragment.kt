package com.example.myapplication.ui.fragments.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.MonstersApplication
import com.example.myapplication.R
import com.example.myapplication.adapters.MonstersAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Monster
import com.example.myapplication.viewmodels.HomeViewModel
import javax.inject.Inject


class HomeFragment : Fragment(), MonstersAdapter.OnItemClick {

    @Inject
    lateinit var viewModel: HomeViewModel
    private lateinit var navController: NavController
    private lateinit var binding: FragmentHomeBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, "onAttach: ")
        (context.applicationContext as MonstersApplication).appComponent.homeSubcomponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
        navController = findNavController()
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

    companion object {
        const val TAG = "MainFragment.java"
    }
}