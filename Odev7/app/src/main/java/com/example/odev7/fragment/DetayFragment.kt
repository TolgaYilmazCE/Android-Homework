package com.example.odev7.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.odev7.R
import com.example.odev7.databinding.FragmentDetayBinding
import com.example.odev7.viewmodel.DetayFragmentVMF
import com.example.odev7.viewmodel.DetayFragmentViewModel


class DetayFragment : Fragment() {
    private lateinit var tasarim:FragmentDetayBinding
    private lateinit var viewModel:DetayFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_detay,container,false)
        tasarim.detayFragment=this
        tasarim.detayToolbarBaslik="Yapılacak İş Detay"

        val bundle:DetayFragmentArgs by navArgs()
        val gelenIs =bundle.yapilacakIs
        tasarim.yapilacakIsNesnesi=gelenIs
        return tasarim.root


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayFragmentViewModel by viewModels(){
            DetayFragmentVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonGuncelle(yapilacaklar_id:Int,yapilacak_is:String){
        viewModel.guncelle(yapilacaklar_id, yapilacak_is)
    }

}