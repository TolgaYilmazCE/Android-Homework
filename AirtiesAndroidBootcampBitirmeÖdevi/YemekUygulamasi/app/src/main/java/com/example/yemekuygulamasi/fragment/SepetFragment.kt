package com.example.yemekuygulamasi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.yemekuygulamasi.R
import com.example.yemekuygulamasi.adapter.SepetAdapter
import com.example.yemekuygulamasi.databinding.FragmentSepetBinding
import com.example.yemekuygulamasi.entity.Sepet
import com.example.yemekuygulamasi.viewmodel.SepetFragmentViewModel

class SepetFragment : Fragment() {
    private lateinit var tasarim:FragmentSepetBinding
    private lateinit var viewModel:SepetFragmentViewModel
    private lateinit var siparisListesi: List<Sepet>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_sepet,container,false)
        tasarim.sepetFragment=this


        viewModel.sepetListesi.observe(viewLifecycleOwner){
            val adapter=SepetAdapter(requireContext(),it,viewModel)
            tasarim.sepetAdapter=adapter
        }


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:SepetFragmentViewModel by viewModels()
        viewModel=tempViewModel
    }
    fun fabAnasayfa(view:View){
        Navigation.findNavController(view).navigate(R.id.action_sepetFragment_to_anasayfaFragment)
    }

}