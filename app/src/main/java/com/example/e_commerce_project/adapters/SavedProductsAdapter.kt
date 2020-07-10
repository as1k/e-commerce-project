package com.example.e_commerce_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_project.R
import com.example.e_commerce_project.model.Category
import com.example.e_commerce_project.model.Product

class SavedProductsAdapter  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var savedProductsList = listOf<Product>()
    private lateinit var productName : TextView
    private lateinit var productPrice : TextView
    private lateinit var productPriceForCredit : TextView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SavedProductsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false)
        )
    }

    override fun getItemCount(): Int = savedProductsList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SavedProductsViewHolder) {
            return holder.bind(savedProductsList[position])
        }
    }

    inner class SavedProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            productName  = itemView.findViewById(R.id.tvProductName)
            productPrice = itemView.findViewById(R.id.tvProductPrice)
            productPriceForCredit = itemView.findViewById(R.id.tvProductPriceToMonth)
            productName.text = product.name
            productPrice.text = product.price.toString()
            productPriceForCredit.text = product.priceForCredit.toString()
        }
    }

    fun addItems(newProductsList: List<Product>) {
        savedProductsList = newProductsList
        notifyDataSetChanged()
    }
}