package com.example.yemekuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemekuygulamasi.entity.Sepet
import com.example.yemekuygulamasi.repo.YemeklerDaoRepository

class YemekDetayFragmentViewModel :ViewModel(){
    val yrepo=YemeklerDaoRepository()
    var siparisListesi=MutableLiveData<List<Sepet>>()

    init {
        siparisleriGetir()
        siparisListesi=yrepo.siparisleriGetir()
    }
    fun siparisleriGetir(){
        yrepo.siparisleriGetir()
    }

   fun sepeteYemekEkle(yemek_adi:String, yemek_resim_adi:String,
                       yemek_fiyat:String, yemek_siparis_adet:String, kullanici_adi:String){
        yrepo.sepeteYemekEkle(
            yemek_adi,yemek_resim_adi,
            yemek_fiyat,yemek_siparis_adet,
            kullanici_adi)
   }

    fun sepetiGetir(kullanici_adi: String) {
        yrepo.sepetiGetir(kullanici_adi="tolga")
    }




}