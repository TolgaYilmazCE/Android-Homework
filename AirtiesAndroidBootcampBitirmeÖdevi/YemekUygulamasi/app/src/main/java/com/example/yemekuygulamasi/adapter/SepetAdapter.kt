package com.example.yemekuygulamasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yemekuygulamasi.databinding.SepetCardTasarimBinding
import com.example.yemekuygulamasi.entity.Sepet
import com.example.yemekuygulamasi.viewmodel.SepetFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepetAdapter(var mContext:Context,
                   var sepetListesi:List<Sepet>,
                   var viewModel:SepetFragmentViewModel
    )
    : RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: SepetCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: SepetCardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val tasarim=SepetCardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)

    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek=sepetListesi.get(position)
        val t=holder.tasarim
        t.textViewSepetYemekAdi.setText("${yemek.yemek_adi}")
        t.textViewSepetYemekFiyati.setText("${yemek.yemek_fiyat} ₺")
        val resimUrl="http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Picasso.get().load(resimUrl).into(t.imageViewSepetYemek)

        t.imageViewYemekSil.setOnClickListener {
            Snackbar.make(it,"${yemek.yemek_adi} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet"){

                    viewModel.yemekSil(yemek.sepet_yemek_id,yemek.kullanici_adi)
                }
                .show()

        }


    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }
}