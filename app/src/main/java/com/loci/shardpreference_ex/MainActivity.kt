package com.loci.shardpreference_ex

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return

        val save1 = findViewById<Button>(R.id.save1)
        save1.setOnClickListener {
            val editText1 = findViewById<EditText>(R.id.editText1)

            with(sharedPref.edit()) {
                putString(MyTestClass.SHARED_VALUE_1, editText1.text.toString())
                apply()
            }
        }

        val read1 = findViewById<Button>(R.id.read1)
        read1.setOnClickListener {
            val sharedVal = sharedPref.getString(MyTestClass.SHARED_VALUE_1, "defaultValue1")

            val readText1 = findViewById<TextView>(R.id.readText1)
            readText1.text = sharedVal
        }


        val save2 = findViewById<Button>(R.id.save2)
        save2.setOnClickListener {
            val editText2 = findViewById<EditText>(R.id.editText2)

            with(sharedPref.edit()) {
                putString(MyTestClass.SHARED_VALUE_2, editText2.text.toString())
                apply()
            }
        }

        val read2 = findViewById<Button>(R.id.read2)
        read2.setOnClickListener {
            val sharedVal = sharedPref.getString(MyTestClass.SHARED_VALUE_2, "defaultValue2")

            val readText2 = findViewById<TextView>(R.id.readText2)
            readText2.text = sharedVal
        }
    }
}