package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private val sharedViewModel: MainViewModel by activityViewModels()
    private lateinit var navController: NavController
    private var binding: FragmentDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        navController = Navigation.findNavController(requireActivity(), R.id.navController)
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