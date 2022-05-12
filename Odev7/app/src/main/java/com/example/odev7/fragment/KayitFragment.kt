package com.example.odev7.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.odev7.R
import com.example.odev7.databinding.FragmentKayitBinding
import com.example.odev7.viewmodel.KayitFragmentVMF
import com.example.odev7.viewmodel.KayitFragmentViewModel

class KayitFragment : Fragment() {
    private lateinit var tasarim:FragmentKayitBinding
    private lateinit var viewModel:KayitFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_kayit,container,false)
        tasarim.kayitFragment =this
        tasarim.kayitToolbarBaslik="Yapılacak İş Kayıt"
        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KayitFragmentViewModel by viewModels(){
            KayitFragmentVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonKaydetTikla(yapilacak_is:String){
        viewModel.kayit(yapilacak_is)
    }

}