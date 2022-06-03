package com.example.yemekuygulamasi.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yemekuygulamasi.R

class SplashFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Handler().postDelayed({
            if (onBoardFinish()){
                findNavController().navigate(R.id.action_splashFragment_to_googleSignInActivity)

            }else{
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        },3000)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardFinish():Boolean{
        val sharedPref=requireActivity().getSharedPreferences("onBoard", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)

    }


}