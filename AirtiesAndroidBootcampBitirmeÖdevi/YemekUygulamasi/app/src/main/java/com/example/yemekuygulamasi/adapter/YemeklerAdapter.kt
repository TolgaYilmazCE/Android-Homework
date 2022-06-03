package com.example.yemekuygulamasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemekuygulamasi.R
import com.example.yemekuygulamasi.databinding.CardTasarimBinding
import com.example.yemekuygulamasi.entity.Yemekler
import com.example.yemekuygulamasi.fragment.AnasayfaFragmentDirections
import com.example.yemekuygulamasi.viewmodel.AnasayfaFragmentViewModel
import com.squareup.picasso.Picasso

class YemeklerAdapter(var mContext:Context,
                      var yemeklerListesi:List<Yemekler>,
                      )
    : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding=DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek=yemeklerListesi.get(position)
        val imageUrl ="http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        val t=holder.tasarim
        t.textViewYemekAdi.setText("${yemek.yemek_adi}")
        t.textViewYemekFiyat.setText("${yemek.yemek_fiyat} ₺")
        Picasso.get().load(imageUrl).into(t.imageView)
        t.satirCard.setOnClickListener {
            val gecis=AnasayfaFragmentDirections.actionAnasayfaFragmentToYemekDetayFragment2(yemek=yemek)
            Navigation.findNavController(it).navigate(gecis)

        }


    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }
}