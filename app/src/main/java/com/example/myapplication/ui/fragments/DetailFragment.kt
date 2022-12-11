package com.example.myapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.myapplication.MonstersApplication
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.viewmodels.HomeViewModel
import javax.inject.Inject


class DetailFragment : Fragment() {
    @Inject
    lateinit var sharedViewModel: HomeViewModel
    private lateinit var navController: NavController
    private var binding: FragmentDetailBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as MonstersApplication).appComponent.homeSubcomponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        navController = Navigation.findNavController(requireActivity(), R.id.navHostFragment)
        val fragmentBinding = FragmentDetailBinding.inflate(inflater, container, false)
        fragmentBinding.lifecycleOwner = this
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = sharedViewModel
            context?.let {
                Glide.with(it)
                    .load(viewModel?.selectedMonster?.value?.thumbnailUrl)
                    .into(monsterImage)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}