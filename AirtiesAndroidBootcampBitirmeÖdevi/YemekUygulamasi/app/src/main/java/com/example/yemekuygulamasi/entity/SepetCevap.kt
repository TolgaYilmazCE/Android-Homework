package com.example.yemekuygulamasi.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SepetCevap(@SerializedName("success") @Expose var success: Int,
                 @SerializedName("sepet_yemekler") @Expose var sepet_yemekler :List<Sepet>) {
}