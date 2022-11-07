package com.example.myapplication.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MonstersApplication
import com.example.myapplication.R
import com.example.myapplication.adapters.MonstersAdapter
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.model.Monster
import javax.inject.Inject


const val TAG = "MainFragment.java"

class MainFragment : Fragment(), MonstersAdapter.OnItemClick {

    @Inject
    lateinit var viewModel: MainViewModel
    private lateinit var navController: NavController
    private lateinit var binding: FragmentMainBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as MonstersApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        navController = Navigation.findNavController(requireActivity(), R.id.navController)
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