package com.example.myapplication.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.MonstersApplication
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodels.MainViewModel
import javax.inject.Inject


const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    @Inject
    lateinit var viewModel: MainViewModel

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MonstersApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.sharedViewModel = viewModel
        Log.i(TAG, "onCreate: ")
        val fragmentContainerView = binding.navController
        val host = fragmentContainerView.getFragment<NavHostFragment>()
        navController = host.navController

        setBottomNav();
    }

    private fun setBottomNav() {
        viewModel.bottomNavState.observe(this) {pos ->
            when(pos) {
                MainViewModel.BottomNavState.HOME -> navController.navigate(R.id.home)
                MainViewModel.BottomNavState.CONTACT -> navController.navigate(R.id.contactFragment)
                MainViewModel.BottomNavState.MUSIC -> navController.navigate(R.id.musicFragment)
                null -> navController.navigate(R.id.homeFragment)
            }
            Log.i(TAG, "setBottomNav: cracra $pos")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i(TAG, "onOptionsItemSelected: ")
        if (item.itemId == android.R.id.home) {
            navController.navigateUp()
        }
        return super.onOptionsItemSelected(item)
    }
}