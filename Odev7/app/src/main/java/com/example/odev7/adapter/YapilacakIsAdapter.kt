package com.example.odev7.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev7.R
import com.example.odev7.databinding.CardTasarimBinding
import com.example.odev7.entity.YapilacakIs
import com.example.odev7.fragment.AnasayfaFragmentDirections
import com.example.odev7.viewmodel.AnasayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class YapilacakIsAdapter(var mContext:Context,
                         var yapilacaklarListesi:List<YapilacakIs>,
                         var viewModel:AnasayfaFragmentViewModel)
    :RecyclerView.Adapter<YapilacakIsAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
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
        val yapilacakIs =yapilacaklarListesi.get(position)
        val t=holder.tasarim

        t.yapilacakIsNesnesi=yapilacakIs

        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it,"${yapilacakIs.yapilacak_is} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.sil(yapilacakIs.yapilacaklar_id)
                }.show()
        }
        t.satirCard.setOnClickListener {
            val gecis=AnasayfaFragmentDirections.detayGecis(yapilacakIs = yapilacakIs)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }

}