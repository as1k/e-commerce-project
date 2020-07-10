package com.example.e_commerce_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_project.R
import com.example.e_commerce_project.model.Category


class CategoriesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var categoriesList = listOf<Category>()
    private lateinit var categoryName : TextView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CategoriesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        )
    }

    override fun getItemCount(): Int = categoriesList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoriesViewHolder) {
            return holder.bind(categoriesList[position])
        }
    }

    inner class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            categoryName  = itemView.findViewById(R.id.tvCategoryName)
            categoryName.text = category.name
        }
    }

    fun addItems(newCategoriesList: List<Category>) {
        categoriesList = newCategoriesList
        notifyDataSetChanged()
    }
}