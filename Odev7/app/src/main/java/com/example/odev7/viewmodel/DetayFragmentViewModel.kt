package com.example.odev7.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.odev7.repo.YapilacaklarDaoRepository

class DetayFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val yrepo =YapilacaklarDaoRepository(application)

    fun guncelle(yapilacaklar_id:Int,yapilacak_is:String){
        yrepo.yapilacakIsGuncelle(yapilacaklar_id,yapilacak_is)
    }
}