package com.example.odev5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.odev5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tasarım:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarım= ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarım.root)
        var sonuc=0

        tasarım.button0.setOnClickListener {
            tasarım.textView2.append("0")
        }

        tasarım.button1.setOnClickListener {
            tasarım.textView2.append("1")
        }

        tasarım.button2.setOnClickListener {
            tasarım.textView2.append("2")
        }

        tasarım.button3.setOnClickListener {
            tasarım.textView2.append("3")
        }

        tasarım.button4.setOnClickListener {
            tasarım.textView2.append("4")
        }

        tasarım.button5.setOnClickListener {
            tasarım.textView2.append("5")
        }

        tasarım.button6.setOnClickListener {
            tasarım.textView2.append("6")
        }

        tasarım.button7.setOnClickListener {
            tasarım.textView2.append("7")
        }

        tasarım.button8.setOnClickListener {
            tasarım.textView2.append("8")
        }

        tasarım.button9.setOnClickListener {
            tasarım.textView2.append("9")
        }

        tasarım.buttonSifirla.setOnClickListener {
            tasarım.textView2.text=""
            sonuc=0
        }

        tasarım.buttonArti.setOnClickListener {


            var sayi=tasarım.textView2.text.toString().toInt()
            tasarım.textView2.text=""
            sonuc+=sayi
            sayi=0


        }
        tasarım.buttonEsittir.setOnClickListener {
            tasarım.textView2.text=(tasarım.textView2.text.toString().toInt()+sonuc).toString()
            sonuc=0
        }

    }
}