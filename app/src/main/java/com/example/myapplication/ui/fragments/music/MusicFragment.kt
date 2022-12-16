package com.example.myapplication.ui.fragments.music

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.MonstersApplication
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMusicBinding
import com.example.myapplication.viewmodels.MusicViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MusicFragment : Fragment() {

    @Inject
    lateinit var viewModel: MusicViewModel

    private var binding: FragmentMusicBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as MonstersApplication).appComponent.musicSubcomponent()
            .create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentMusicBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.viewModel = viewModel
        this.binding = binding
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.releaseMediaPlayer()
        binding = null
    }
}