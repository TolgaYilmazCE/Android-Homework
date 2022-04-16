package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev4.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var tasarim:FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.buttonGitA.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.aSayfasinaGecis)
        }
        tasarim.buttonGitX.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.xSayfasinaGecis)
        }
        return tasarim.root
    }


}