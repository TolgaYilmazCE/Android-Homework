package com.example.odev7.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.odev7.entity.YapilacakIs
import com.example.odev7.repo.YapilacaklarDaoRepository

class AnasayfaFragmentViewModel(application: Application) :AndroidViewModel(application) {
    val yrepo=YapilacaklarDaoRepository(application)
    var yapilacaklarListesi = MutableLiveData<List<YapilacakIs>>()

    init {
        yapilacakIsYukle()
        yapilacaklarListesi=yrepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi:String){
        yrepo.yapilacakIsAra(aramaKelimesi)
    }

    fun sil(yapilacaklar_id:Int){
        yrepo.yapilacakIsSil(yapilacaklar_id)
    }

    fun yapilacakIsYukle(){
        yrepo.tumYapilacaklariAl()
    }
}