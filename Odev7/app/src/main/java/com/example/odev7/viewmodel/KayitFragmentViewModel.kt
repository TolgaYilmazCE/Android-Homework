package com.example.odev7.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.odev7.repo.YapilacaklarDaoRepository

class KayitFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val yrepo=YapilacaklarDaoRepository(application)

    fun kayit(yapilacak_is:String){
        yrepo.yapilacakIsKayit(yapilacak_is)
    }
}