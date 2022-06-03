package com.example.yemekuygulamasi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.yemekuygulamasi.R
import com.example.yemekuygulamasi.databinding.FragmentYemekDetayBinding
import com.example.yemekuygulamasi.entity.Sepet
import com.example.yemekuygulamasi.viewmodel.YemekDetayFragmentViewModel
import com.squareup.picasso.Picasso


class YemekDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentYemekDetayBinding
    private lateinit var viewModel:YemekDetayFragmentViewModel
    private lateinit var siparisListesi: List<Sepet>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim =DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay,container,false)
        tasarim.yemekDetayFragment=this
        tasarim.kullaniciAdi="Tolga"

        val bundle:YemekDetayFragmentArgs by navArgs()
        val gelenYemek=bundle.yemek
        tasarim.gelenYemekNesnesi=gelenYemek
        resimYemek(gelenYemek.yemek_resim_adi)
        viewModel.sepetiGetir("Tolga")
        viewModel.siparisListesi.observe(viewLifecycleOwner){
            siparisListesi= it
        }



        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:YemekDetayFragmentViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun resimYemek(resimAdi:String){
        val resimUrl ="http://kasimadalan.pe.hu/yemekler/resimler/$resimAdi"
        Picasso.get().load(resimUrl).into(tasarim.imageViewDetayResim)
    }

    fun artiButton(textView:TextView){
        if (textView.text=="0"){
            textView.text="1"
        }else{
            var sayi=textView.text.toString().toInt()
            sayi=sayi+1
            textView.text=sayi.toString()
        }
    }

    fun eksiButton(textView: TextView){
        if (textView.text=="0"){

        }else{
            var sayi=textView.text.toString().toInt()
            sayi=sayi-1
            textView.text=sayi.toString()
        }
    }

    fun sepeteEkle(yemek_adi:String,
                   yemek_resim_adi:String,
                   yemek_fiyat:String,
                   yemek_siparis_adet:String,
                   kullanici_adi:String){
        var sayi=yemek_siparis_adet.toInt()

        Toast.makeText(requireContext(),"$yemek_siparis_adet adet $yemek_adi sepete eklendi", Toast.LENGTH_SHORT).show()
        viewModel.sepeteYemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, sayi.toString(), kullanici_adi)


    }
    fun fabAnasayfa(view:View){
        Navigation.findNavController(view).navigate(R.id.action_yemekDetayFragment2_to_anasayfaFragment)
    }

    fun fabSepet(view:View){
        Navigation.findNavController(view).navigate(R.id.action_yemekDetayFragment2_to_sepetFragment)
    }

}