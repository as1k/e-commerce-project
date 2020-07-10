package com.example.e_commerce_project.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_project.R
import com.example.e_commerce_project.adapters.CategoriesInHomeAdapter
import com.example.e_commerce_project.adapters.ProductsInHomeAdapter
import com.example.e_commerce_project.model.Category
import com.example.e_commerce_project.model.Product
import java.util.ArrayList

class HomeFragment : Fragment() {
    private lateinit var categoriesInHomeRecView: RecyclerView
    private lateinit var productsInHomeRecView: RecyclerView
    private lateinit var categoriesInHomeAdapter: CategoriesInHomeAdapter
    private lateinit var productsInHomeAdapter: ProductsInHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        categoriesInHomeRecView = rootView.findViewById(R.id.rv_categories_in_home)
        categoriesInHomeAdapter = CategoriesInHomeAdapter()
        categoriesInHomeAdapter.addItems(categoriesInHomeGenerator())

        categoriesInHomeRecView.layoutManager =
            GridLayoutManager(requireActivity(), 2, GridLayoutManager.HORIZONTAL, false)
        categoriesInHomeRecView.adapter = categoriesInHomeAdapter

        productsInHomeRecView = rootView.findViewById(R.id.rv_products_in_home)
        productsInHomeAdapter = ProductsInHomeAdapter()
        productsInHomeAdapter.addItems(productsInHomeGenerator())

        productsInHomeRecView.layoutManager = GridLayoutManager(requireActivity(), 2)
        productsInHomeRecView.adapter = productsInHomeAdapter

        return rootView
    }

    private fun categoriesInHomeGenerator(): List<Category> {
        val items: MutableList<Category> = ArrayList<Category>()
        for (i in 0..14) {
            val category = Category(
                "Категория #$i"
            )
            items.add(category)
        }
        return items
    }

    private fun productsInHomeGenerator(): List<Product> {
        val items: MutableList<Product> = ArrayList<Product>()
        for (i in 0..50) {
            val product = Product(
                "Продукт #$i",
                1000 + i,
                82 + i
            )
            items.add(product)
        }
        return items
    }
}