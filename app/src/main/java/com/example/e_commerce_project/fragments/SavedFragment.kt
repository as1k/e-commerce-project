package com.example.e_commerce_project.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_project.R
import com.example.e_commerce_project.adapters.CategoriesAdapter
import com.example.e_commerce_project.adapters.SavedProductsAdapter
import com.example.e_commerce_project.model.Category
import com.example.e_commerce_project.model.Product
import java.util.ArrayList

class SavedFragment : Fragment() {
    private lateinit var savedProductsRecView: RecyclerView
    private lateinit var adapter: SavedProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_saved, container, false)

        savedProductsRecView = rootView.findViewById(R.id.rv_saved_products)
        adapter = SavedProductsAdapter()
        adapter.addItems(productsGenerator())

        savedProductsRecView.layoutManager = LinearLayoutManager(requireActivity())
        savedProductsRecView.adapter = adapter
        return rootView
    }

    private fun productsGenerator(): List<Product> {
        val items: MutableList<Product> = ArrayList()
        for (i in 0..25) {
            val product = Product(
                "Продукт #$i",
                2221 + i,
                184 + i
            )
            items.add(product)
        }
        return items
    }

}