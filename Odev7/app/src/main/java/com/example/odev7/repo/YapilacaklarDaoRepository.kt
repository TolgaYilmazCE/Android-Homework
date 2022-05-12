package com.example.odev7.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.odev7.entity.YapilacakIs
import com.example.odev7.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarDaoRepository(var application: Application) {
    var yapilacaklarListesi:MutableLiveData<List<YapilacakIs>>
    var vt:Veritabani

    init {
        yapilacaklarListesi= MutableLiveData()
        vt= Veritabani.veritabaniErisim(application)!!
    }

    fun yapilacaklariGetir():MutableLiveData<List<YapilacakIs>>{
        return yapilacaklarListesi
    }

    fun yapilacakIsKayit(yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniYapilacakIs=YapilacakIs(0,yapilacak_is)
            vt.yapilacaklarDao().yapilacakIsEkle(yeniYapilacakIs)
        }
    }

    fun yapilacakIsGuncelle(yapilacaklar_id:Int,yapilacak_is: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenYapilacakIs =YapilacakIs(yapilacaklar_id, yapilacak_is)
            vt.yapilacaklarDao().yapilacakIsGuncelle(guncellenenYapilacakIs)
        }
    }

    fun yapilacakIsAra(aramaKelimesi:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value=vt.yapilacaklarDao().yapilacakIsArama(aramaKelimesi)
        }
    }

    fun yapilacakIsSil(yapilacaklar_id: Int){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val silinenYapilacakIs=YapilacakIs(yapilacaklar_id,"")
            vt.yapilacaklarDao().yapilacakIsSil(silinenYapilacakIs)
            tumYapilacaklariAl()
        }
    }

    fun tumYapilacaklariAl(){
        val job= CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value=vt.yapilacaklarDao().tumYapilacakIsler()
        }
    }
}