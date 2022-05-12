package com.example.odev6

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.odev6.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim:FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.toolbarAnasayfa.title=""
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        tasarim.rv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)



        val giysilerListesi=ArrayList<Giysiler>()
        val g1=Giysiler(1,"Relaxed Fit Fermuarlı Kargo Pantalon","giysi1",499.99)
        val g2=Giysiler(2,"Relaxed Fit Keten Karışımlı Gömlek","giysi2",379.99)
        val g3=Giysiler(3,"Relaxed Fit Kısa Kollu Keten Karışımlı Gömlek","giysi3",319.99)
        val g4=Giysiler(4,"Relaxed Fit Kapüşonlu Üst","giysi4",249.99)

        giysilerListesi.add(g1)
        giysilerListesi.add(g2)
        giysilerListesi.add(g3)
        giysilerListesi.add(g4)



        val adapter=GiysilerAdapter(requireContext(),giysilerListesi)
        tasarim.rv.adapter=adapter




        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }
    fun ara(aramaKelimesi:String){
        Log.e("Giysi ara",aramaKelimesi)
    }
}