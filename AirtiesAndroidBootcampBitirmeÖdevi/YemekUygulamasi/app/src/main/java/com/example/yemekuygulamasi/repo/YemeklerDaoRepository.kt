package com.example.yemekuygulamasi.repo

import androidx.lifecycle.MutableLiveData
import com.example.yemekuygulamasi.entity.*
import com.example.yemekuygulamasi.retrofit.ApiUtils
import com.example.yemekuygulamasi.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository {
    var yemeklerListesi:MutableLiveData<List<Yemekler>>
    var siparisListesi:MutableLiveData<List<Sepet>>
    var ydao: YemeklerDaoInterface

    init {
        ydao=ApiUtils.getYemeklerDaoInterface()
        yemeklerListesi= MutableLiveData()
        siparisListesi= MutableLiveData()
    }

    fun yemekleriGetir() : MutableLiveData<List<Yemekler>>{
        return yemeklerListesi
    }

    fun siparisleriGetir():MutableLiveData<List<Sepet>>{
        return siparisListesi
    }

    fun sepeteYemekEkle(
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: String,
        yemek_siparis_adet: String,
        kullanici_adi: String
    ){
        val siparisler=siparisListesi.value
        ydao.sepeteYemekEkle(
            yemek_adi,
            yemek_resim_adi,
            yemek_fiyat,
            yemek_siparis_adet,
            kullanici_adi).enqueue(object :Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val basari= response.body()?.success
                val mesaj= response.body()?.message
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {

            }
        })

    }

    fun sepetiGetir(kullanici_adi: String){
        ydao.sepettekiYemekleriGetir(kullanici_adi="tolga").enqueue(object : Callback<SepetCevap>{
            override fun onResponse(call: Call<SepetCevap>, response: Response<SepetCevap>) {
                if (response.body()!=null){
                    val list= response.body()?.sepet_yemekler
                    siparisListesi.value=list
                }
            }

            override fun onFailure(call: Call<SepetCevap>?, t: Throwable?) {

            }
        })
    }

    fun sepettenYemekSil(sepet_yemek_id:String,kullanici_adi: String){
        ydao.sepettenYemekSil(sepet_yemek_id, kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                sepetiGetir(kullanici_adi)
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {

            }
        })
    }


    fun tumYemekleriAl(){
        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap>{
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val liste = response.body()?.yemekler
                yemeklerListesi.value=liste
            }

            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })
    }
}