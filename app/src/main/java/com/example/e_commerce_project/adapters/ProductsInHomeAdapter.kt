package com.example.e_commerce_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_project.R
import com.example.e_commerce_project.model.Product

class ProductsInHomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var productsInHomeList = listOf<Product>()
    private lateinit var productName : TextView
    private lateinit var productPrice : TextView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProductsInHomeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_in_home, parent, false)
        )
    }

    override fun getItemCount(): Int = productsInHomeList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductsInHomeViewHolder) {
            return holder.bind(productsInHomeList[position])
        }
    }

    inner class ProductsInHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            productName  = itemView.findViewById(R.id.tv_product_name_in_home)
            productPrice  = itemView.findViewById(R.id.tv_product_price_in_home)
            productName.text = product.name
            productPrice.text = product.price.toString()
        }
    }

    fun addItems(newProductInHomeList: List<Product>) {
        productsInHomeList = newProductInHomeList
        notifyDataSetChanged()
    }
}