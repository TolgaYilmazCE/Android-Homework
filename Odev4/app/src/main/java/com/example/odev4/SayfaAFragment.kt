package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev4.databinding.FragmentSayfaABinding


class SayfaAFragment : Fragment() {
    private lateinit var tasarim:FragmentSayfaABinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentSayfaABinding.inflate(inflater, container, false)

        tasarim.buttonGitB.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.bSayfasinaGecis)
        }

        return tasarim.root
    }


}