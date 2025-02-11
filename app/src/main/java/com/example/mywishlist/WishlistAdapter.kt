package com.example.mywishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val items: MutableList<Wishlist>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView: TextView = itemView.findViewById(R.id.nameItem)
        val priceTextView: TextView = itemView.findViewById(R.id.priceItem)
        val urlTextView: TextView = itemView.findViewById(R.id.urlItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.my_wishlist, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.urlTextView.text = item.url
        holder.priceTextView.text = item.price.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}