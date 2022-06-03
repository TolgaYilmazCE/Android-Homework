package com.example.yemekuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemekuygulamasi.entity.Yemekler
import com.example.yemekuygulamasi.repo.YemeklerDaoRepository

class AnasayfaFragmentViewModel:ViewModel() {
    val yrepo=YemeklerDaoRepository()
    var yemeklerListesi=MutableLiveData<List<Yemekler>>()

    init {
        yemekleriGetir()
        yemeklerListesi=yrepo.yemekleriGetir()
    }

    fun yemekleriGetir(){
        yrepo.tumYemekleriAl()
    }
}