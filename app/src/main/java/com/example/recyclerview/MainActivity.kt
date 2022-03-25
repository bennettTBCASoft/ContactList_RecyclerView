package com.example.recyclerview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Contact(val name: String, val phone: String)


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyAdapter
    private val contacts = ArrayList<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultLaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            result.data?.extras?.let {
                if(result.resultCode == Activity.RESULT_OK) {
                    val name = it.getString("name") ?: return@let
                    val phone = it.getString("phone") ?: return@let
                    contacts.add(Contact(name, phone))
                    adapter.notifyDataSetChanged()
                }
            }
        }

        // 將變數與XML綁定
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btn_nextPage = findViewById<Button>(R.id.btn_nextSecond)

        // 設定垂直佈局
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        // 建立MyAdapter並連結recyclerView
        adapter = MyAdapter(contacts)
        recyclerView.adapter = adapter

        // 設定按鈕監聽
        btn_nextPage.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            resultLaunch.launch(intent)
        }

    }
}