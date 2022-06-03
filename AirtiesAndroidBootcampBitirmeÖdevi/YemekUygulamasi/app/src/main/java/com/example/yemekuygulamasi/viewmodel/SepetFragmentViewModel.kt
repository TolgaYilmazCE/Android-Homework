package com.example.yemekuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemekuygulamasi.entity.Sepet
import com.example.yemekuygulamasi.repo.YemeklerDaoRepository

class SepetFragmentViewModel:ViewModel() {
    val yrepo=YemeklerDaoRepository()
    var sepetListesi=MutableLiveData<List<Sepet>>()

    init {
        sepetYemekleriGetir()
        sepetListesi=yrepo.siparisleriGetir()
    }

    fun yemekSil(sepet_yemek_id:String, kullanici_adi:String){
        yrepo.sepettenYemekSil(sepet_yemek_id,kullanici_adi)
    }

    fun sepetYemekleriGetir(){
        yrepo.sepetiGetir(kullanici_adi = "TolgaYilmaz")
    }
}