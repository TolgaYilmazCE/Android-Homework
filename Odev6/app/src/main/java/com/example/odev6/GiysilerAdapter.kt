package com.example.odev6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6.databinding.CardTasarimBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.Override as Override1

class GiysilerAdapter (var mContext:Context,var giysilerListesi:List<Giysiler>) : RecyclerView.Adapter<GiysilerAdapter.CardTasarimTutucu>()
{

    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: CardTasarimBinding
        init {
            this.tasarim=tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val tasarim=CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val giysi=giysilerListesi.get(position)
        val g=holder.tasarim

        g.imageViewGiysi.setImageResource(
            mContext.resources.getIdentifier(giysi.giysiResimAdi,"drawable",mContext.packageName))
        g.textViewGiysiAd.text=giysi.giysiAdi
        g.textViewGiysiFiyat.text="${giysi.giysiFiyat} ₺"
        g.imageButtonFavori.bringToFront()

        g.imageButtonFavori.setOnClickListener {
            g.imageButtonFavori.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
            Snackbar.make(it,"${giysi.giysiAdi} favorilere eklendi ",Snackbar.LENGTH_LONG).show()
        }
        g.imageButtonFavori.bringToFront()

    }

    override fun getItemCount(): Int {
        return giysilerListesi.size
    }

}