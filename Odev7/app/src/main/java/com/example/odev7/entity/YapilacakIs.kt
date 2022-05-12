package com.example.odev7.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "yapilacaklar")
data class YapilacakIs(@PrimaryKey(autoGenerate = true)
                       @ColumnInfo(name = "yapilacaklar_id") @NotNull var yapilacaklar_id:Int,
                       @ColumnInfo(name = "yapilacak_is") @NotNull var yapilacak_is:String) :Serializable{
}