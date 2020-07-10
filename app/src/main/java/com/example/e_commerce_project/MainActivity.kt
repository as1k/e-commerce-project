package com.example.e_commerce_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.e_commerce_project.fragments.*
import com.example.e_commerce_project.utils.StoreViewPager
import com.example.e_commerce_project.utils.StoreViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var pager: StoreViewPager
    private lateinit var pagerAdapter: StoreViewPagerAdapter

    private var homeFragment: Fragment = HomeFragment()
    private var categoriesFragment: Fragment = CategoriesFragment()
    private var shopCartFragment: Fragment = ShopCartFragment()
    private var savedFragment: Fragment = SavedFragment()
    private var profileFragment: Fragment = ProfileFragment()

    private var fragmentList: MutableList<Fragment> = ArrayList()
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        setFragment()
    }

    private fun bindViews() {
        bottomNavView = findViewById(R.id.bottom_navigation)
        fragmentList.add(homeFragment)
        fragmentList.add(categoriesFragment)
        fragmentList.add(shopCartFragment)
        fragmentList.add(savedFragment)
        fragmentList.add(profileFragment)
        pager = findViewById(R.id.pager)

        pager.offscreenPageLimit = 5
        pager.setSwiping(false)
        pagerAdapter = StoreViewPagerAdapter(supportFragmentManager, fragmentList)
        pager.adapter = pagerAdapter
    }

    private fun setFragment() {
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    item.setIcon(R.drawable.ic_home_clicked)
                    pager.setCurrentItem(0, false)
                    bottomNavView.menu.findItem(R.id.categories)
                        .setIcon(R.drawable.ic_category_not_clicked)
                    bottomNavView.menu.findItem(R.id.shopCart)
                        .setIcon(R.drawable.ic_shop_cart_not_clicked)
                    bottomNavView.menu.findItem(R.id.saved)
                        .setIcon(R.drawable.ic_saved_not_clicked)
                    bottomNavView.menu.findItem(R.id.profile)
                        .setIcon(R.drawable.ic_profile_not_clicked)
                }
                R.id.categories -> {
                    pager.setCurrentItem(1, false)
                    item.setIcon(R.drawable.ic_category_clicked)
                    bottomNavView.menu.findItem(R.id.home)
                        .setIcon(R.drawable.ic_home_not_clicked)
                    bottomNavView.menu.findItem(R.id.shopCart)
                        .setIcon(R.drawable.ic_shop_cart_not_clicked)
                    bottomNavView.menu.findItem(R.id.saved)
                        .setIcon(R.drawable.ic_saved_not_clicked)
                    bottomNavView.menu.findItem(R.id.profile)
                        .setIcon(R.drawable.ic_profile_not_clicked)
                }
                R.id.shopCart -> {
                    pager.setCurrentItem(2, false)
                    item.setIcon(R.drawable.ic_shop_cart_clicked)
                    bottomNavView.menu.findItem(R.id.home)
                        .setIcon(R.drawable.ic_home_not_clicked)
                    bottomNavView.menu.findItem(R.id.categories)
                        .setIcon(R.drawable.ic_category_not_clicked)
                    bottomNavView.menu.findItem(R.id.saved)
                        .setIcon(R.drawable.ic_saved_not_clicked)
                    bottomNavView.menu.findItem(R.id.profile)
                        .setIcon(R.drawable.ic_profile_not_clicked)
                }
                R.id.saved -> {
                    pager.setCurrentItem(3, false)
                    item.setIcon(R.drawable.ic_saved_clicked)
                    bottomNavView.menu.findItem(R.id.home)
                        .setIcon(R.drawable.ic_home_not_clicked)
                    bottomNavView.menu.findItem(R.id.categories)
                        .setIcon(R.drawable.ic_category_not_clicked)
                    bottomNavView.menu.findItem(R.id.shopCart)
                        .setIcon(R.drawable.ic_shop_cart_not_clicked)
                    bottomNavView.menu.findItem(R.id.profile)
                        .setIcon(R.drawable.ic_profile_not_clicked)
                }
                R.id.profile -> {
                    pager.setCurrentItem(4, false)
                    item.setIcon(R.drawable.ic_profile_clicked)
                    bottomNavView.menu.findItem(R.id.home)
                        .setIcon(R.drawable.ic_home_not_clicked)
                    bottomNavView.menu.findItem(R.id.categories)
                        .setIcon(R.drawable.ic_category_not_clicked)
                    bottomNavView.menu.findItem(R.id.shopCart)
                        .setIcon(R.drawable.ic_shop_cart_not_clicked)
                    bottomNavView.menu.findItem(R.id.saved)
                        .setIcon(R.drawable.ic_saved_not_clicked)
                }
            }
            false
        }
    }
}