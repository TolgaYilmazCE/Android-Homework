package com.example.odev7.room

import androidx.room.*
import com.example.odev7.entity.YapilacakIs

@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumYapilacakIsler():List<YapilacakIs>

    @Insert
    suspend fun yapilacakIsEkle(yapilacakIs: YapilacakIs)

    @Update
    suspend fun yapilacakIsGuncelle(yapilacakIs: YapilacakIs)

    @Delete
    suspend fun yapilacakIsSil(yapilacakIs: YapilacakIs)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%' || :aramaKelimesi || '%'")
    suspend fun yapilacakIsArama(aramaKelimesi:String) : List<YapilacakIs>
}