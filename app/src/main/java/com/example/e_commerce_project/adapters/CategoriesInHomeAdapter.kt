package com.example.e_commerce_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_project.R
import com.example.e_commerce_project.model.Category

class CategoriesInHomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var categoriesInHomeList = listOf<Category>()
    private lateinit var categoryName : TextView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CategoriesInHomeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category_in_home, parent, false)
        )
    }

    override fun getItemCount(): Int = categoriesInHomeList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoriesInHomeViewHolder) {
            return holder.bind(categoriesInHomeList[position])
        }
    }

    inner class CategoriesInHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            categoryName  = itemView.findViewById(R.id.tv_category_name_in_home)
            categoryName.text = category.name
        }
    }

    fun addItems(newCategoriesList: List<Category>) {
        categoriesInHomeList = newCategoriesList
        notifyDataSetChanged()
    }
}