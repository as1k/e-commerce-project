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
import com.example.e_commerce_project.model.Category
import java.util.*

class CategoriesFragment : Fragment() {
    private lateinit var categoriesRecView: RecyclerView
    private lateinit var adapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_categories, container, false)

        categoriesRecView = rootView.findViewById(R.id.rv_categories)
        adapter = CategoriesAdapter()
        adapter.addItems(categoriesGenerator())

        categoriesRecView.layoutManager = LinearLayoutManager(requireActivity())
        categoriesRecView.adapter = adapter
        return rootView
    }

    private fun categoriesGenerator(): List<Category> {
//        val loremIpsum = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        val items: MutableList<Category> = ArrayList<Category>()
        for (i in 0..14) {
            val category = Category(
                "Категория #$i"
            )
            items.add(category)
        }
        return items
    }

}