package com.example.yemekuygulamasi.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.yemekuygulamasi.R
import kotlinx.android.synthetic.main.fragment_birinci_ekran.view.*


class BirinciEkranFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_birinci_ekran, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager2)

        view.OnBoardBirNextTextView.setOnClickListener {
            viewPager?.currentItem=1
        }

        return view
    }

}