package com.example.mywishlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var items: MutableList<Wishlist>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = mutableListOf()

        val myWishlist = findViewById<RecyclerView>(R.id.myWishlist)
        val itemName = findViewById<TextInputEditText>(R.id.itemName)
        val itemUrl = findViewById<TextInputEditText>(R.id.itemURL)
        val itemPrice = findViewById<EditText>(R.id.itemPrice)
        val submitButton = findViewById<Button>(R.id.submitButton)

        val Wishlistadapter = WishlistAdapter(items)
        myWishlist.adapter = Wishlistadapter
        myWishlist.layoutManager = LinearLayoutManager(this)


        submitButton.setOnClickListener {
            val newItem : Wishlist = Wishlist(
                itemName.text.toString(),
                itemUrl.text.toString(),
                itemPrice.text.toString().toDouble().toString()
            )
            items.add(newItem)
            Wishlistadapter.notifyItemInserted(items.size - 1)
            itemName.text?.clear()
            itemUrl.text?.clear()
            itemPrice.text.clear()

        }
    }
}