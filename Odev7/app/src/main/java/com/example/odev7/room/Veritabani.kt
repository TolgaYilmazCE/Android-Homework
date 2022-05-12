package com.example.odev7.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.odev7.entity.YapilacakIs

@Database(entities = [YapilacakIs::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun yapilacaklarDao() : YapilacaklarDao

    companion object {
        var INSTANCE:Veritabani? = null

        fun veritabaniErisim(context: Context) : Veritabani? {
            if (INSTANCE == null){
                synchronized(Veritabani::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        Veritabani::class.java,
                        "yapilacaklar.sqlite").createFromAsset("yapilacaklar.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}